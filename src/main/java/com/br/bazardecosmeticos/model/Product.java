package com.br.bazardecosmeticos.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.text.DecimalFormat;

/**
 * Created by lailson on 9/6/16.
 */

@Entity
public class Product {
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

    public double getProductDiscount(){
        DecimalFormat df = new DecimalFormat("#00");
        double discount = Math.abs(((getProductDiscountedPrice()/getProductOriginalPrice()) -1)*100);
        return Double.valueOf(df.format(discount));
    }

    public void setProductDiscount(double productDiscount) {
        this.productDiscount = productDiscount;
    }

    /*public void setProductDiscount(){
        DecimalFormat df = new DecimalFormat("#00");
        double discount = Math.abs(((getProductDiscountedPrice()/getProductOriginalPrice()) -1)*100);
        this.productDiscount = Double.valueOf(df.format(discount));
    }*/
}
