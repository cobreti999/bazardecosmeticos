package com.br.bazardecosmeticos.controller.admin;

import com.br.bazardecosmeticos.model.Customer;
import com.br.bazardecosmeticos.model.CustomerOrder;
import com.br.bazardecosmeticos.model.Product;
import com.br.bazardecosmeticos.service.CustomerOrderService;
import com.br.bazardecosmeticos.service.ProductService;
import com.br.bazardecosmeticos.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by lailson on 9/16/16.
 */

@Controller
@RequestMapping("/admin")
public class AdminHome {

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerServiceImpl customerService;

    @Autowired
    private CustomerOrderService customerOrderService;

    @RequestMapping
    public String adminPage() {
        return "admin";
    }

    @RequestMapping("/productInventory")
    public String productInventory(Model model) {
        List<Product> products = productService.getProductList();
        model.addAttribute("products", products);
        return "productInventory";
    }

    @RequestMapping("/customer")
    public String customerManagement(Model model) {
        List<Customer> customerList = customerService.getAllCustomers();
        model.addAttribute(customerList);

        return "customerManagement";
    }

    @RequestMapping("/customerOrder")
    public String orderManagement(Model model) {
        List<CustomerOrder> customerOrderList = customerOrderService.getAllCustomerOrders();
        model.addAttribute(customerOrderList);
        return "customerOrderManagement";
    }

}
