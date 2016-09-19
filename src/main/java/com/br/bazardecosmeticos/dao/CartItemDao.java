package com.br.bazardecosmeticos.dao;

import com.br.bazardecosmeticos.model.Cart;
import com.br.bazardecosmeticos.model.CartItem;

/**
 * Created by lailson on 9/19/16.
 */
public interface CartItemDao {
    void addCartItem(CartItem cartItem);

    void removeCartItem (CartItem cartItem);

    void removeAllCartItems (Cart cart);

    CartItem getCartItemByProductId (int productId);
}
