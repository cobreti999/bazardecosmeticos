package com.br.bazardecosmeticos.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lailson on 9/12/16.
 */
public class Cart {
    private String cartId;
    private Map<String, CartItem> cartItems;
    private double grandTotalDiscountedPrice;
    private double grandTotalOriginalPrice;

    private Cart(){
        cartItems = new HashMap<String, CartItem>();
        grandTotalDiscountedPrice = 0;
        grandTotalOriginalPrice = 0;
    }

    public Cart(String cartId){
        this();
        this.cartId = cartId;
    }


    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public Map<String, CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Map<String, CartItem> cartItems) {
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
        String productId = String.valueOf(item.getProduct().getProductId());
        if (cartItems.containsKey(productId)){
            CartItem existingCartItem = cartItems.get(productId);
            existingCartItem.setQuantity(existingCartItem.getQuantity()+item.getQuantity());
            existingCartItem.setTotalDiscountedPrice(existingCartItem.getTotalDiscountedPrice() +
                    item.getTotalDiscountedPrice());
            existingCartItem.setTotalOriginalPrice(existingCartItem.getTotalOriginalPrice() +
                    item.getTotalOriginalPrice());
            cartItems.put(productId, existingCartItem);
        }else{
            cartItems.put(productId, item);
        }
        updateGrandTotal();
    }

    public void removeCartItem(CartItem item){
        int productId = item.getProduct().getProductId();
        cartItems.remove(String.valueOf(productId));
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
