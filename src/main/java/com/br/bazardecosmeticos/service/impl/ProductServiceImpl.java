package com.br.bazardecosmeticos.service.impl;

import com.br.bazardecosmeticos.dao.ProductDao;
import com.br.bazardecosmeticos.model.Product;
import com.br.bazardecosmeticos.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lailson on 9/16/16.
 */

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductDao productDao;

    public Product getProductById(int productId) {
        return productDao.getProductById(productId);
    }

    public List<Product> getProductList() {
        return productDao.getProductList();
    }

    public void addProduct(Product product) {
        productDao.addProduct(product);
    }

    public void editProduct(Product product) {
        productDao.editProduct(product);
    }

    public void deleteProduct(Product product){
        productDao.deleteProduct(product);
    }
}
