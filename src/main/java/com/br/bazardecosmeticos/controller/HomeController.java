package com.br.bazardecosmeticos.controller;

import com.br.bazardecosmeticos.dao.ProductDao;
import com.br.bazardecosmeticos.model.Product;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by lailson on 9/5/16.
 */

@Controller
public class HomeController {

    private Path path;

    @Autowired
    private ProductDao productDao;

    @RequestMapping("/")
    public String home(){
        return "home"; //return home.jsp page when it finds the root page
    }

    @RequestMapping("/productList")
    public String getProducts(Model model){
        List<Product> products = productDao.getAllProducts();
        model.addAttribute("products",products);
        return "productList";
    }

    @RequestMapping("/productList/viewProduct/{productId}")
    public String viewProduct(@PathVariable int productId, Model model) throws IOException {
        Product product = productDao.getProductById(productId);
        model.addAttribute(product);
        return "viewProduct";
    }

    @RequestMapping("/admin")
    public String adminPage(){
        return "admin";
    }

    @RequestMapping("/admin/productInventory")
    public String productInventory(Model model){
        List<Product> products = productDao.getAllProducts();
        model.addAttribute("products", products);
        return "productInventory";
    }

    @RequestMapping("/admin/productInventory/addProduct")
    public String addProduct(Model model){
        Product product = new Product();
        //Default selected values
        product.setProductCategory("instrument");
        product.setProductCondition("new");
        product.setProductStatus("active");
        model.addAttribute("product", product);
        return "addProduct";
    }

    //User clicks on addProduct submit button
    @RequestMapping(value = "/admin/productInventory/addProduct", method = RequestMethod.POST)
    //Grabs the product from the addProduct jsp view page
    public String addProductPost(@Valid @ModelAttribute("product") Product product, BindingResult result, HttpServletRequest request){
        if (result.hasErrors()){
            return "addProduct";
        }
        productDao.addProduct(product);
        MultipartFile productImage = product.getProductImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        //gets the path in a way that works for both Windows or Unix systems
        String normalizedPath = FilenameUtils.normalize(rootDirectory + "/WEB-INF/resources/images/" +
                product.getProductId()+ ".png");
        path = Paths.get(normalizedPath);
        System.out.println("path.toString() = " + path.toString());
        if (productImage != null && !productImage.isEmpty()){
            try {
                productImage.transferTo(new File(path.toString()));
            }catch (Exception e){
                e.printStackTrace();
                throw new RuntimeException("Product Image saving failed", e);
            }
        }
        return "redirect:/admin/productInventory";
    }

    @RequestMapping("/admin/productInventory/deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id, HttpServletRequest request){
        //Delete the file from the resources folder
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        //gets the path in a way that works for both Windows or Unix systems
        String normalizedPath = FilenameUtils.normalize(rootDirectory + "/WEB-INF/resources/images/" +
                id+ ".png");
        path = Paths.get(normalizedPath);
        if (Files.exists(path)){
            try{
                Files.delete(path);
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        //delete the Product from the database
        productDao.deleteProduct(id);
        return "redirect:/admin/productInventory";
    }

    @RequestMapping("/admin/productInventory/editProduct/{productId}")
    public String editProduct(@PathVariable int productId, Model model){
        Product product = productDao.getProductById(productId);
        model.addAttribute(product);
        return "editProduct";
    }

    @RequestMapping(value = "/admin/productInventory/editProduct", method = RequestMethod.POST)
    public String editProduct(@Valid @ModelAttribute("product") Product product, BindingResult result, HttpServletRequest request){
        if (result.hasErrors()){
            return "editProduct";
        }
        MultipartFile productImage = product.getProductImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        String normalizedPath = FilenameUtils.normalize(rootDirectory + "/WEB-INF/resources/images/" +
                product.getProductId()+ ".png");
        path = Paths.get(normalizedPath);
        if (productImage != null && !productImage.isEmpty()){
            try{
                productImage.transferTo(new File(path.toString()));
            }catch(Exception e){
                e.printStackTrace();
                throw new RuntimeException("Product Image  saving failed!", e);
            }
        }
        productDao.editProduct(product);
        return "redirect:/admin/productInventory";
    }

}
