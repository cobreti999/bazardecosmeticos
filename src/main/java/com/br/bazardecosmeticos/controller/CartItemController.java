package com.br.bazardecosmeticos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lailson on 9/12/16.
 */

@Controller
@RequestMapping("/cart")
//RequestMapping no nivel de classe significa que o path real sempre inicia com /cart
public class CartItemController {

    @RequestMapping
    public String get(HttpServletRequest request){
        //Usamos a session id como sendo o cartId
        return "redirect:/cart/" + request.getSession(true).getId();
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
    public String getCart(@PathVariable (value = "cartId") int cartId, Model model){
        model.addAttribute("cartId", cartId);
        return "cart";
    }
}
