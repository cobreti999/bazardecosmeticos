package com.br.bazardecosmeticos.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lailson on 9/12/16.
 */
public class Cart {
    private int cartId;
    private Map<Integer, CartItem> cartItems;
    private double grandTotalDiscountedPrice;
    private double grandTotalOriginalPrice;

    private Cart(){
        cartItems = new HashMap<Integer, CartItem>();
        grandTotalDiscountedPrice = 0;
        grandTotalOriginalPrice = 0;
    }

    public Cart(int cartId){
        this();
        this.cartId = cartId;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public Map<Integer, CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Map<Integer, CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public double getGrandTotalDiscountedPrice() {
        return grandTotalDiscountedPrice;
    }

    public void setGrandTotalDiscountedPrice(double grandTotalDiscountedPrice) {
        this.grandTotalDiscountedPrice = grandTotalDiscountedPrice;
    }

    public double getGrandTotalOriginalPrice() {
        return grandTotalOriginalPrice;
    }

    public void setGrandTotalOriginalPrice(double grandTotalOriginalPrice) {
        this.grandTotalOriginalPrice = grandTotalOriginalPrice;
    }

    public void addCartIdem(CartItem item){
        int productId = item.getProduct().getProductId();
        if (cartItems.containsKey(productId)){
            CartItem existingCartItem = cartItems.get(productId);
            existingCartItem.setQuantity(existingCartItem.getQuantity()+item.getQuantity());
            cartItems.put(productId, existingCartItem);
        }else{
            cartItems.put(productId, item);
        }
        updateGrandTotal();
    }

    public void removeCartItem(CartItem item){
        int productId = item.getProduct().getProductId();
        cartItems.remove(productId);
        updateGrandTotal();
    }

    public void updateGrandTotal(){
        grandTotalDiscountedPrice =0;
        grandTotalOriginalPrice = 0;
        for (CartItem item : cartItems.values()){
            grandTotalDiscountedPrice = grandTotalDiscountedPrice + item.getTotalDiscountedPrice();
            grandTotalOriginalPrice = grandTotalOriginalPrice + item.getTotalOriginalPrice();
        }
    }

}
