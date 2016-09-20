package com.br.bazardecosmeticos.controller;

import com.br.bazardecosmeticos.model.Cart;
import com.br.bazardecosmeticos.model.Customer;
import com.br.bazardecosmeticos.model.CustomerOrder;
import com.br.bazardecosmeticos.service.CartService;
import com.br.bazardecosmeticos.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lailson on 9/19/16.
 */
@Controller
public class OrderController {

    @Autowired
    private CartService cartService;

    @Autowired
    private CustomerOrderService customerOrderService;

    @RequestMapping("/order/{cartId}")
    public String createOrder (@PathVariable("cartId") int cartId) {
        CustomerOrder customerOrder = new CustomerOrder();
        Cart cart = cartService.getCartById(cartId);
        customerOrder.setCart(cart);
        Customer customer = cart.getCustomer();
        customerOrder.setCustomer(customer);
        customerOrder.setShippingAddress(customer.getShippingAddress());
        customerOrder.setBillingAddress(customer.getBillingAddress());

        customerOrderService.addCustomerOrder(customerOrder);
        //will go to cart checkout workflow
        return "redirect:/checkout?cartId="+cartId;
    }
}
