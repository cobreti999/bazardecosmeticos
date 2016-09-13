package com.br.bazardecosmeticos.controller;

import com.br.bazardecosmeticos.dao.CartDao;
import com.br.bazardecosmeticos.dao.ProductDao;
import com.br.bazardecosmeticos.model.Cart;
import com.br.bazardecosmeticos.model.CartItem;
import com.br.bazardecosmeticos.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lailson on 9/12/16.
 */

@Controller
@RequestMapping("/rest/cart")
public class CartController {

    @Autowired
    private CartDao cartDao;

    @Autowired
    private ProductDao productDao;

    //ResponseBody is for returning a model object (Card) in the format of a json
    //We retrieve the cartId from the url and put that in the model
    @RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
    public @ResponseBody Cart read(@PathVariable(value = "cartId") int cartId){
        //Return the Cart with the cartId in the url
        return cartDao.read(cartId);
    }

    //PUT - update method from http
    @RequestMapping(value = "/{cartId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@PathVariable(value = "cartId") int cartId, @RequestBody Cart cart){
        //RequestBody - Spring Takes the body of the request and transform it to a cart (contrario do ResponseBody)
        cartDao.update(cartId, cart);
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    //Retrieve the PathVariable, gives it the valueName of "cartId" and give it's value to the int cartId
    public void delete(@PathVariable(value = "cartId") int cartId ){
        cartDao.delete(cartId);
    }

    @RequestMapping(value = "/add/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addItem(@PathVariable(value = "productId") int productId, HttpServletRequest request){
        String teste = request.getSession(true).getId();
        System.out.println("SESSAO TESTE: " + teste);int sessionId=0;
        try {
            sessionId = Integer.parseInt(request.getSession(true).getId());
        }catch(Exception e){e.printStackTrace();}
        Cart cart = cartDao.read(sessionId);
        if (cart == null){
            cart = cartDao.create(new Cart(sessionId));
        }
        Product product = productDao.getProductById(productId);
        if (product == null){
            throw new IllegalArgumentException(new Exception());
        }
        cart.addCartIdem(new CartItem(product));
        cartDao.update(sessionId,cart);
    }

    @RequestMapping(value = "/remove/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable int productId, HttpServletRequest request){
        int sessionId = Integer.parseInt(request.getSession(true).getId());
        Cart cart = cartDao.read(sessionId);
        if (cart == null){
            cart = cartDao.create(new Cart(sessionId));
        }
        Product product = productDao.getProductById(productId);
        if (product == null){
            throw new IllegalArgumentException(new Exception());
        }
        cart.removeCartItem(new CartItem(product));
        cartDao.update(sessionId,cart);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request, please verify your payload")
    public void handleClientErrors(Exception e){}

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error")
    public void handleServerErrors(Exception e){}

}
