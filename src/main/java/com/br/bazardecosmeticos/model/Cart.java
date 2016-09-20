package com.br.bazardecosmeticos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by lailson on 9/12/16.
 */

@Entity
public class Cart implements Serializable{

    private static final long serialVersionUID = 4319849415624180013L;

    @Id
    @GeneratedValue
    private int cartId;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CartItem> cartItems;

    @OneToOne
    @JoinColumn(name = "customerId")
    @JsonIgnore
    private Customer customer;

    private double grandTotalOriginal;
    private double grandTotalDiscounted;

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getGrandTotalOriginal() {
        return grandTotalOriginal;
    }

    public void setGrandTotalOriginal(double grandTotalOriginal) {
        this.grandTotalOriginal = grandTotalOriginal;
    }

    public double getGrandTotalDiscounted() {
        return grandTotalDiscounted;
    }

    public void setGrandTotalDiscounted(double grandTotalDiscounted) {
        this.grandTotalDiscounted = grandTotalDiscounted;
    }
}
