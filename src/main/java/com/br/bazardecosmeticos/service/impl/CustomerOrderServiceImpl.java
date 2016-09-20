package com.br.bazardecosmeticos.service.impl;

import com.br.bazardecosmeticos.dao.CustomerOrderDao;
import com.br.bazardecosmeticos.model.Cart;
import com.br.bazardecosmeticos.model.CartItem;
import com.br.bazardecosmeticos.model.CustomerOrder;
import com.br.bazardecosmeticos.service.CartService;
import com.br.bazardecosmeticos.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lailson on 9/19/16.
 */

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

    @Autowired
    private CustomerOrderDao customerOrderDao;

    @Autowired
    private CartService cartService;

    public void addCustomerOrder(CustomerOrder customerOrder) {
        customerOrderDao.addCustomerOrder(customerOrder);
    }

    public double getCustomerOrderGrandTotalOriginalPrice(int cartId) {
        double grandTotal=0;
        Cart cart = cartService.getCartById(cartId);
        List<CartItem> cartItems = cart.getCartItems();

        for (CartItem item : cartItems) {
            grandTotal=grandTotal+item.getTotalOriginalPrice();
        }

        return grandTotal;
    }

    public double getCustomerOrderGrandTotalDiscountedPrice(int cartId) {
        double grandTotal=0;
        Cart cart = cartService.getCartById(cartId);
        List<CartItem> cartItems = cart.getCartItems();

        for (CartItem item : cartItems) {
            grandTotal=grandTotal+item.getTotalDiscountedPrice();
        }

        return grandTotal;
    }
}
