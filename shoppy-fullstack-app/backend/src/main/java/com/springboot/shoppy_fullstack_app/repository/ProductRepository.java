package com.springboot.shoppy_fullstack_app.repository;

import com.springboot.shoppy_fullstack_app.dto.Product;
import com.springboot.shoppy_fullstack_app.dto.ProductDetailinfo;

import java.util.List;

public interface ProductRepository {
    ProductDetailinfo findProductDetailinfo(int pid);
    Product findByPid(int pid);
    List<Product> findAll();
}
