package com.br.bazardecosmeticos.dao;

import com.br.bazardecosmeticos.model.Product;

import java.util.List;

/**
 * Created by lailson on 9/8/16.
 */
public interface ProductDao {

    void addProduct(Product product);

    void editProduct(Product product);

    Product getProductById(int id);

    List<Product> getAllProducts();

    void deleteProduct(int id);
}
