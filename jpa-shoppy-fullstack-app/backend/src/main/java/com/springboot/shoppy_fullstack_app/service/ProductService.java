package com.springboot.shoppy_fullstack_app.service;

import com.springboot.shoppy_fullstack_app.dto.ProductDto;
import com.springboot.shoppy_fullstack_app.dto.ProductDetailinfo;
import com.springboot.shoppy_fullstack_app.dto.ProductQna;
import com.springboot.shoppy_fullstack_app.dto.ProductReturn;

import java.util.List;

public interface ProductService {
    ProductReturn findReturn();
    List<ProductQna>  findQna(int pid);
    ProductDetailinfo findDetailinfo(int pid);
    ProductDto findByPid(int pid);
    List<ProductDto> findAll();
}
