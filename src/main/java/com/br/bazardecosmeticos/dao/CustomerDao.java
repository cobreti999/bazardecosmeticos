package com.br.bazardecosmeticos.dao;

import com.br.bazardecosmeticos.model.Customer;

import java.util.List;

/**
 * Created by lailson on 9/17/16.
 */
public interface CustomerDao {

    void addCustomer (Customer customer);

    Customer getCustomerById (int customerId);

    Customer getCustomerByUsername (String username);

    List<Customer> getAllCustomers();

    void editCustomer(Customer customer);

    void deleteCustomer(Customer customer);
}
