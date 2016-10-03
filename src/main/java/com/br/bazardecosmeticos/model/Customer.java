package com.br.bazardecosmeticos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by lailson on 9/14/16.
 */

@Entity
public class Customer implements Serializable{

    private static final long serialVersionUID = 1628339856973323128L;

    @Id
    @GeneratedValue
    private int customerId;

    @NotEmpty(message = "O nome do cliente não pode ser vazio.")
    private String customerName;

    @NotEmpty(message = "O email não pode ser vazio")
    private String customerEmail;

    private String customerPhone;

    @NotEmpty(message = "Nome de usuário não pode ser vazio.")
    private String username;

    @NotEmpty(message = "Sua senha não pode ser vazia.")
    private String password;

    private boolean enabled;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "billingAdressId")
    private BillingAddress billingAddress;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "shippingAdressId")
    private ShippingAddress shippingAddress;

    @OneToOne
    @JoinColumn(name = "cartId")
    @JsonIgnore
    private Cart cart;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
