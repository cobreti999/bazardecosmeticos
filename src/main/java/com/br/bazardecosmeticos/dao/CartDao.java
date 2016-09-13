package com.br.bazardecosmeticos.dao;

import com.br.bazardecosmeticos.model.Cart;

/**
 * Created by lailson on 9/12/16.
 */
public interface CartDao {

    Cart create(Cart cart);
    /*Cart read(int cartId);
    void update(int cartId, Cart cart);
    void delete(int cartId);*/
    Cart read(String cartId);
    void update(String cartId, Cart cart);
    void delete(String cartId);
}
