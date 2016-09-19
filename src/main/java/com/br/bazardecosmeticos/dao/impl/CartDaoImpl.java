package com.br.bazardecosmeticos.dao.impl;

import com.br.bazardecosmeticos.dao.CartDao;
import com.br.bazardecosmeticos.model.Cart;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

/**
 * Created by lailson on 9/19/16.
 */
@Repository
@Transactional
public class CartDaoImpl implements CartDao{

    @Autowired
    private SessionFactory sessionFactory;

    //@Autowired
    //private CustomerOrderService customerOrderService;

    public Cart getCartById (int cartId) {
        Session session = sessionFactory.getCurrentSession();
        return (Cart) session.get(Cart.class, cartId);
    }

    /*public Cart validate(int cartId) throws IOException {
        Cart cart = getCartById(cartId);
        if (cart == null || cart.getCartItems().size() == 0) {
            throw new IOException(cartId+"");
        }
        update(cart);
        return cart;
    }*/

    public void update(Cart cart) {
        int cartId = cart.getCartId();
        //to do
        //double grandTotal = customerOrderService.getCustomerOrderGrandTotal(cartId);
        //cart.setGrandTotal(grandTotal);

        //Session session = sessionFactory.getCurrentSession();
        //session.saveOrUpdate(cart);

    }
}
