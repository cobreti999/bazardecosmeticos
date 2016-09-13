package com.br.bazardecosmeticos.dao.impl;

import com.br.bazardecosmeticos.dao.CartDao;
import com.br.bazardecosmeticos.model.Cart;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lailson on 9/12/16.
 */

//DAO classes should be registered as Beans (Repository tag) (could be @Controller or @Service also.
//It depends on the class purpose. After the @Repository, this class can be @AutoWired by the Controller
@Repository
public class CartDaoImpl implements CartDao{

    private Map<Integer, Cart> listOfCarts;

    public CartDaoImpl() {
        this.listOfCarts = new HashMap<Integer, Cart>();
    }

    @Override
    public Cart create(Cart cart) {
        if (listOfCarts.keySet().contains(cart.getCartId())){
            throw new IllegalArgumentException(String.format("Impossible to create a cart. " +
                    "A cart with the given id already exists.", cart.getCartId()));
        }
        listOfCarts.put(cart.getCartId(), cart);
        return cart;
    }

    @Override
    public Cart read(int cartId) {
        return listOfCarts.get(cartId);
    }

    @Override
    public void update(int cartId, Cart cart) {
        if (!listOfCarts.keySet().contains(cartId)){
            throw new IllegalArgumentException(String.format("Impossible to update cart. " +
                    "A cart with this id doesn't exists.", cart.getCartId()));
        }
        listOfCarts.put(cartId, cart);
    }

    @Override
    public void delete(int cartId) {
        if (!listOfCarts.keySet().contains(cartId)){
            throw new IllegalArgumentException(String.format("Cannot delete cart. " +
                    "A cart with this id doesn't exists.", cartId));
        }
        listOfCarts.remove(cartId);
    }
}
