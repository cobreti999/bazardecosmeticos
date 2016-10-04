package com.br.bazardecosmeticos.dao;

import com.br.bazardecosmeticos.model.CustomerOrder;

import java.util.List;

/**
 * Created by lailson on 9/19/16.
 */
public interface CustomerOrderDao {
    void addCustomerOrder(CustomerOrder customerOrder);

    List<CustomerOrder> getAllCustomerOrders();
}
