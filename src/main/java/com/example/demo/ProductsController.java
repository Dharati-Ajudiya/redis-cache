package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    ProductService productService;

    @GetMapping
    public List<Products> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Products findProduct(@PathVariable int id) {
        return productService.findProduct(id);
    }

    @DeleteMapping
    public void deleteProduct(){
        productService.deleteProduct();
    }
}
