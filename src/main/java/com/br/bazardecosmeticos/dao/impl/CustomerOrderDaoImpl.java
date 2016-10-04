package com.br.bazardecosmeticos.dao.impl;

import com.br.bazardecosmeticos.dao.CustomerOrderDao;
import com.br.bazardecosmeticos.model.CustomerOrder;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lailson on 9/19/16.
 */

@Repository
@Transactional
public class CustomerOrderDaoImpl implements CustomerOrderDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addCustomerOrder(CustomerOrder customerOrder) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customerOrder);
        session.flush();
    }

    public List<CustomerOrder> getAllCustomerOrders(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from CustomerOrder");
        List<CustomerOrder> customerOrderList = query.list();
        return customerOrderList;
    }

}
