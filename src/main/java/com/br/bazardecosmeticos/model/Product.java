package com.br.bazardecosmeticos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by lailson on 9/6/16.
 */

@Entity
public class Product implements Serializable{
    //usamos o spring-workflow pro processo de checkout, por isso devemos tornar
    //todos os modelos do webflow Serializable e gerar o serialVersionUID
    private static final long serialVersionUID = 2733318732423618061L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;

    @NotEmpty(message = "O produto precisa ter um nome.")
    private String productName;
    private String productType;
    private String productDescription;

    @Min(value = 0, message = "O produto precisa ter preço maior que 0")
    private double productOriginalPrice;
    @Min(value = 0, message = "O produto precisa ter preço maior que 0")
    private double productDiscountedPrice;
    private double productDiscount;
    private String productStatus;

    @Min(value = 0, message = "The product unit must not be less than 0.")
    private int unitInStock;
    private String productBrand;

    //with the transient annotation, hibernate won't create a column in the table for productImage
    //the image will be stored in resources
    @Transient
    private MultipartFile productImage;

    /*
    A relação entre Product e CartItem é de 1:N. 1 produto pode estar relacionado a N cartItems (List)
    (de vários clientes) e cada cartItem só pode ter 1 objeto product (com diferentes quantidades obviamente)
    Usamos o hibernate para representar essa relação. MappedBy diz que a classe CartItem terá um atributo product
    CascadeType.ALL diz que todas as operações em Produto serão propagadas para CartItems (PERSIST, REMOVE, REFRESH...)
    automaticamente pelo Hibernate. FechType diz repeito a quando o hibernate vai buscar no DB a coluna relativa a
    esse atributo (cartItemList). LAZY = Só é carregado depois de um getCartItemList(), EAGER = é carregado
    automaticamente junto com o resto da tabela.
    Observações: só listas possuem mappedBy e listas não possuem @joinColumn
    */
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    //Prevents the serialization of this field quando ocorre a serializacao em JSON object. Isso é util pois podem
    //ocorrer loops infinitos em relacionamentos entre 2 classes onde uma espera pela outra. Para que isso não ocorra
    //uma prática comum é a de marcar um desses membros de uma das classes como @JsonIgnore.
    private List<CartItem> cartItemList;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getProductOriginalPrice() {
        return productOriginalPrice;
    }

    public void setProductOriginalPrice(double productOriginalPrice) {
        this.productOriginalPrice = productOriginalPrice;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public int getUnitInStock() {
        return unitInStock;
    }

    public void setUnitInStock(int unitInStock) {
        this.unitInStock = unitInStock;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public MultipartFile getProductImage() {
        return productImage;
    }

    public void setProductImage(MultipartFile productImage) {
        this.productImage = productImage;
    }

    public double getProductDiscountedPrice() {
        return productDiscountedPrice;
    }

    public void setProductDiscountedPrice(double productDiscountedPrice) {
        this.productDiscountedPrice = productDiscountedPrice;
    }

    /*public double getProductDiscount() {
        return productDiscount;
    }*/

    public void setProductDiscount(double productDiscount) {
        this.productDiscount = productDiscount;
    }

    public double getProductDiscount(){
        DecimalFormat df = new DecimalFormat("#00");
        double discount = Math.abs(((getProductDiscountedPrice()/getProductOriginalPrice()) -1)*100);
        return Double.valueOf(df.format(discount));
    }

    public void setProductDiscount(){
        DecimalFormat df = new DecimalFormat("#00");
        double discount = Math.abs(((getProductDiscountedPrice()/getProductOriginalPrice()) -1)*100);
        this.productDiscount = Double.valueOf(df.format(discount));
    }

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }
}
