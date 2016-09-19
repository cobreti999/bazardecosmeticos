package com.br.bazardecosmeticos.service.impl;

import com.br.bazardecosmeticos.dao.CartDao;
import com.br.bazardecosmeticos.model.Cart;
import com.br.bazardecosmeticos.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lailson on 9/19/16.
 */

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    private CartDao cartDao;

    public Cart getCartById (int cartId) {
        return cartDao.getCartById(cartId);
    }

    public void update(Cart cart) {
        cartDao.update(cart);
    }
}
