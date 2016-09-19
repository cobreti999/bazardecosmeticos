package com.br.bazardecosmeticos.controller;

import com.br.bazardecosmeticos.model.Customer;
import com.br.bazardecosmeticos.service.CartService;
import com.br.bazardecosmeticos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by lailson on 9/19/16.
 */

@Controller
@RequestMapping("/customer/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private CustomerService customerService;

    @RequestMapping
    public String getCart(@AuthenticationPrincipal User activeUser) {
        //@AuthenticationPrincial is used to get the information about the current user logged in
        Customer customer = customerService.getCustomerByUsername(activeUser.getUsername());
        int cartId = customer.getCart().getCartId();
        return "redirect:/customer/cart/"+cartId;
    }

    @RequestMapping(value="/{cartId}", method = RequestMethod.GET)
    public String getCartRedirect(@PathVariable(value = "cartId") int cartId, Model model) {
        model.addAttribute("cartId", cartId);
        return "cart";
    }
    //These two methods are just to add the cartId to the model
}
