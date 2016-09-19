package com.br.bazardecosmeticos.controller;

import com.br.bazardecosmeticos.model.Cart;
import com.br.bazardecosmeticos.model.CartItem;
import com.br.bazardecosmeticos.model.Customer;
import com.br.bazardecosmeticos.model.Product;
import com.br.bazardecosmeticos.service.CartItemService;
import com.br.bazardecosmeticos.service.CartService;
import com.br.bazardecosmeticos.service.CustomerService;
import com.br.bazardecosmeticos.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lailson on 9/19/16.
 */
@Controller
@RequestMapping("/rest/cart")
public class CartResources {

    @Autowired
    private CartService cartService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CartItemService cartItemService;

    @RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
    public
    @ResponseBody //ResponseBody converts the resulting cart into a json object to the cartview page.
    Cart getCartById(@PathVariable(value = "cartId") int cartId) {
        return cartService.getCartById(cartId);
    }

    @RequestMapping(value = "/add/{productId}", method = RequestMethod.PUT) //PUT to update
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addItem(@PathVariable(value = "productId") int productId, @AuthenticationPrincipal User activeUser) {

        Customer customer = customerService.getCustomerByUsername(activeUser.getUsername());
        Cart cart = customer.getCart();
        Product product = productService.getProductById(productId);
        List<CartItem> cartItems = cart.getCartItems();

        //If we already have the product in the cart: increase the quantity and update price
        for (int i = 0; i < cartItems.size(); i++) {
            if (product.getProductId() == cartItems.get(i).getProduct().getProductId()) {
                CartItem cartItem = cartItems.get(i);
                cartItem.setQuantity(cartItem.getQuantity() + 1);
                cartItem.setTotalDiscountedPrice(product.getProductDiscountedPrice() * cartItem.getQuantity());
                cartItem.setTotalOriginalPrice(product.getProductOriginalPrice() * cartItem.getQuantity());
                cartItemService.addCartItem(cartItem);
                return;
            }
        }

        //If we don't have the product in the cart, create a new CartItem with the product
        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(1);
        cartItem.setTotalDiscountedPrice(product.getProductDiscountedPrice() * cartItem.getQuantity());
        cartItem.setTotalOriginalPrice(product.getProductOriginalPrice() * cartItem.getQuantity());
        cartItem.setCart(cart);
        cartItemService.addCartItem(cartItem);
    }


    @RequestMapping(value = "/remove/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable int productId) {
        CartItem cartItem = cartItemService.getCartItemByProductId(productId);
        cartItemService.removeCartItem(cartItem);
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "cartId") int cartId) {
        Cart cart = cartService.getCartById(cartId);
        cartItemService.removeAllCartItems(cart);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Requisição ilegal. Verifique os dados enviados.")
    public void handleClientErrors(Exception e) {
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Erro no servidor.")
    public void handleServerErrors(Exception e) {
    }
}

