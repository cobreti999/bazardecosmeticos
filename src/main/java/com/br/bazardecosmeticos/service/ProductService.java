package com.br.bazardecosmeticos.service;

import com.br.bazardecosmeticos.model.Product;

import java.util.List;

/**
 * Created by lailson on 9/16/16.
 */
public interface ProductService {
    Product getProductById(int id);

    List<Product> getProductList ();

    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(Product product);
}
