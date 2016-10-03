package com.br.bazardecosmeticos.service.impl;

import com.br.bazardecosmeticos.dao.CustomerDao;
import com.br.bazardecosmeticos.model.Customer;
import com.br.bazardecosmeticos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lailson on 9/17/16.
 */

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public void addCustomer (Customer customer) {
        customerDao.addCustomer(customer);
    }

    public Customer getCustomerById (int customerId) {
        return customerDao.getCustomerById(customerId);
    }

    public Customer getCustomerByUsername (String username) {
        return customerDao.getCustomerByUsername(username);
    }

    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    public void editCustomer(Customer customer){
        customerDao.editCustomer(customer);
    }

    public void deleteCustomer(Customer customer){
        customerDao.deleteCustomer(customer);
    }
}
