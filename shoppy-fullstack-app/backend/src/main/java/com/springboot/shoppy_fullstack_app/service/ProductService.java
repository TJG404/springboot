package com.springboot.shoppy_fullstack_app.service;

import com.springboot.shoppy_fullstack_app.dto.Product;
import com.springboot.shoppy_fullstack_app.dto.ProductDetailinfo;

import java.util.List;

public interface ProductService {
    ProductDetailinfo findDetailinfo(int pid);
    Product findByPid(int pid);
    List<Product> findAll();
}
