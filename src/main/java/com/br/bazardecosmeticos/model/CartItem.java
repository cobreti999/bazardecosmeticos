package com.br.bazardecosmeticos.model;

/**
 * Created by lailson on 9/12/16.
 */
public class CartItem {
    private Product product;
    private int quantity;
    private double totalDiscountedPrice;
    private double totalOriginalPrice;

    public CartItem(){

    }

    public CartItem(Product product) {
        this.product = product;
        this.quantity = 1;
        this.totalDiscountedPrice = product.getProductDiscountedPrice();
        this.totalOriginalPrice = product.getProductOriginalPrice();
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

    public double getTotalDiscountedPrice() {
        return totalDiscountedPrice;
    }

    public void setTotalDiscountedPrice(double totalDiscountedPrice) {
        this.totalDiscountedPrice = totalDiscountedPrice;
    }

    public double getTotalOriginalPrice() {
        return totalOriginalPrice;
    }

    public void setTotalOriginalPrice(double totalOriginalPrice) {
        this.totalOriginalPrice = totalOriginalPrice;
    }
}
