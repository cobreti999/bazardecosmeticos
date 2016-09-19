package com.br.bazardecosmeticos.service;

import com.br.bazardecosmeticos.model.Cart;

/**
 * Created by lailson on 9/19/16.
 */

public interface CartService {
    Cart getCartById (int cartId);

    void update(Cart cart);
}
