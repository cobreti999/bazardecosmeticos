package com.br.bazardecosmeticos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by lailson on 9/12/16.
 */

@Entity
public class CartItem implements Serializable{

    private static final long serialVersionUID = -7926889303988129648L;

    @Id
    @GeneratedValue
    private int cartItemId;

    //O relacionamento entre CartItem e Cart é de N:1. Cada CartItem só pertence a 1 Cart.
    //1 cart pode ter N CartItems. O JoinColumn é pra dizer que na tabela CartItem a gente vai ter um campo
    //para se referir a classe Cart e o nome da coluna será cartId (primary key). Join column indica o dono
    //do relacionamento (só deve ser adicionado em uma das classes)
    @ManyToOne
    @JoinColumn(name = "cartId")
    @JsonIgnore
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    private int quantity;
    private double totalOriginalPrice;
    private double totalDiscountedPrice;

    public int getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(int cartItemId) {
        this.cartItemId = cartItemId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalOriginalPrice() {
        return totalOriginalPrice;
    }

    public void setTotalOriginalPrice(double totalOriginalPrice) {
        this.totalOriginalPrice = totalOriginalPrice;
    }

    public double getTotalDiscountedPrice() {
        return totalDiscountedPrice;
    }

    public void setTotalDiscountedPrice(double totalDiscountedPrice) {
        this.totalDiscountedPrice = totalDiscountedPrice;
    }
}
