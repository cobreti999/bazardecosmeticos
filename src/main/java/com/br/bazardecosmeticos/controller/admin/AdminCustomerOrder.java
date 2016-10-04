package com.br.bazardecosmeticos.controller.admin;

import com.br.bazardecosmeticos.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lailson on 10/3/16.
 */

@Controller
@RequestMapping("/admin/customerOrder")
public class AdminCustomerOrder {

    @Autowired
    public CustomerOrderService customerOrderService;

    @RequestMapping("/editCustomerOrder/{id}")
    public String editCustomerOrder(@PathVariable("id") int id, Model model){
        return "editCustomerOrder";
    }

    @RequestMapping("/deleteCustomerOrder/{id}")
    public String deleteCustomerOrder(@PathVariable("id") int id, Model model){
        return "redirect:/admin/customerOrder";
    }



}
