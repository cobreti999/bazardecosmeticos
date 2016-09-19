package com.br.bazardecosmeticos.service;

import com.br.bazardecosmeticos.model.Cart;
import com.br.bazardecosmeticos.model.CartItem;

/**
 * Created by lailson on 9/19/16.
 */
public interface CartItemService {
    void addCartItem(CartItem cartItem);

    void removeCartItem (CartItem cartItem);

    void removeAllCartItems (Cart cart);

    CartItem getCartItemByProductId (int productId);
}
