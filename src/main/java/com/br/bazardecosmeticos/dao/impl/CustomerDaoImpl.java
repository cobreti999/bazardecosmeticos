package com.br.bazardecosmeticos.dao.impl;

import com.br.bazardecosmeticos.dao.CustomerDao;
import com.br.bazardecosmeticos.model.Authorities;
import com.br.bazardecosmeticos.model.Cart;
import com.br.bazardecosmeticos.model.Customer;
import com.br.bazardecosmeticos.model.Users;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lailson on 9/17/16.
 */

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        //Customer has references to BillingAdress, ShippingAdress and Cart, so we need to make sure that
        //these members are already set (the other members from Customer were already definined by the form in
        //registerCustomer.jsp.
        //The user already set all fields of BillingAdress from the registerCustomer.jsp form however,
        //the customer field on the BillingAddress class is not set
        customer.getBillingAddress().setCustomer(customer);
        customer.getShippingAddress().setCustomer(customer);

        session.saveOrUpdate(customer);
        session.saveOrUpdate(customer.getBillingAddress());
        session.saveOrUpdate(customer.getShippingAddress());

        //The form sent the informations to the Customer, but we need also to create an user
        Users newUser = new Users();
        newUser.setUsername(customer.getUsername());
        newUser.setPassword(customer.getPassword());
        newUser.setEnabled(true);
        newUser.setCustomerId(customer.getCustomerId());

        Authorities newAuthority = new Authorities();
        newAuthority.setUsername(customer.getUsername());
        newAuthority.setAuthority("ROLE_USER");
        session.saveOrUpdate(newUser);
        session.saveOrUpdate(newAuthority);

        Cart newCart = new Cart();
        newCart.setCustomer(customer);
        customer.setCart(newCart);
        session.saveOrUpdate(customer);
        session.saveOrUpdate(newCart);

        session.flush();
    }

    public Customer getCustomerById (int customerId) {
        Session session = sessionFactory.getCurrentSession();
        return (Customer) session.get(Customer.class, customerId);
    }

    public Customer getCustomerByUsername (String username) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Customer where username = ?");
        query.setString(0, username);
        //the first ? is the '0' in the setString which is going to be set as the
        //username in the parameter of getCustomerByUsername

        return (Customer) query.uniqueResult();
    }

    public List<Customer> getAllCustomers () {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Customer");
        List<Customer> customerList = query.list();
        return customerList;
    }

    public void editCustomer(Customer customer){
        Session session = sessionFactory.getCurrentSession();
        customer.getBillingAddress().setCustomer(customer);
        customer.getShippingAddress().setCustomer(customer);
        Cart cart = getCartByCustomerId(customer.getCustomerId());
        /*Query query = session.createQuery("from Cart where customerId = ?");
        query.setParameter(0, customer.getCustomerId());
        Cart cart = (Cart) query.uniqueResult();*/
        cart.setCustomer(customer);
        customer.setCart(cart);
        customer.setEnabled(true);
        session.merge(customer);
        session.merge(customer.getBillingAddress());
        session.merge(customer.getShippingAddress());
        session.flush();

        //todo se usuario editar username e password nao funcionará.
        //Preciso colocar atributo Users dentro de Customer
    }

    public void deleteCustomer(Customer customer){
        Session session = sessionFactory.getCurrentSession();
        //delete the user
        Query query = session.createQuery("delete Users where customerId = ?");
        query.setParameter(0, customer.getCustomerId());
        query.executeUpdate();
        query = session.createQuery("delete Authorities where username = ?");
        query.setParameter(0, customer.getUsername());
        query.executeUpdate();

        //delete the dependencies
        session.delete(customer.getCart());
        session.delete(customer.getBillingAddress());
        session.delete(customer.getShippingAddress());
        //delete the customer
        session.delete(customer);
        session.flush();
    }

    public Cart getCartByCustomerId(int id){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Cart where customerId = ?");
        query.setParameter(0, id);
        return (Cart) query.uniqueResult();
    }
}

