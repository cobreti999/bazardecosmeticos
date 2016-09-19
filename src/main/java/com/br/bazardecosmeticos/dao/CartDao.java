package com.br.bazardecosmeticos.dao;

import com.br.bazardecosmeticos.model.Cart;

/**
 * Created by lailson on 9/12/16.
 */

public interface CartDao {

    Cart getCartById (int cartId);

    void update(Cart cart);
}
