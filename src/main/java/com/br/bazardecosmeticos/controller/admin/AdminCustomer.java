package com.br.bazardecosmeticos.controller.admin;

import com.br.bazardecosmeticos.model.Customer;
import com.br.bazardecosmeticos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by lailson on 9/27/16.
 */

@Controller
@RequestMapping("/admin/customer")
public class AdminCustomer {

    @Autowired
    CustomerService customerService;

    @RequestMapping("/editCustomer/{id}")
    public String editCustomer(@PathVariable("id") int id, Model model){
        Customer customer = customerService.getCustomerById(id);
        model.addAttribute(customer);
        return "editCustomer";
    }

    @RequestMapping(value = "/editCustomer", method = RequestMethod.POST)
    public String editCustomerPost(@Valid @ModelAttribute("customer") Customer customer, BindingResult result){
        if (result.hasErrors()){
            System.out.println("erro");
            return "editCustomer";
        }
        customerService.editCustomer(customer);
        return "redirect:/admin/customer";
    }

    @RequestMapping("/deleteCustomer/{id}")
    public String deleteProduct(@PathVariable int id, Model model) {
        Customer customer = customerService.getCustomerById(id);
        customerService.deleteCustomer(customer);
        return "redirect:/admin/customer";
    }

}
