package com.br.bazardecosmeticos.service;

import com.br.bazardecosmeticos.model.CustomerOrder;

import java.util.List;

/**
 * Created by lailson on 9/19/16.
 */
public interface CustomerOrderService {

    void addCustomerOrder(CustomerOrder customerOrder);

    double getCustomerOrderGrandTotalOriginalPrice(int cartId);

    double getCustomerOrderGrandTotalDiscountedPrice(int cartId);

    List<CustomerOrder> getAllCustomerOrders();

}
