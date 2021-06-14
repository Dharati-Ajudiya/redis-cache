package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableCaching
public class ProductService {

    @Autowired
    ProductDao productDao;


    @Cacheable(value = "all products")
    public List<Products> getAllProducts(){
        System.out.println("from db");
        return productDao.findAll();
    }


    @Cacheable(key = "#id",value = "products")
    public Products findProduct(int id) {
        System.out.println("from db");
        return productDao.findById(id).get();
    }

    @CacheEvict(value = "all products",allEntries = true)
    public void deleteProduct(){
        productDao.deleteAll();
    }


}
