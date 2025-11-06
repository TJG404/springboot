package com.springboot.shoppy_fullstack_app.repository;

import com.springboot.shoppy_fullstack_app.dto.ProductDto;
import com.springboot.shoppy_fullstack_app.dto.ProductDetailinfoDto;
import com.springboot.shoppy_fullstack_app.dto.ProductQna;
import com.springboot.shoppy_fullstack_app.dto.ProductReturn;

import java.util.List;

public interface ProductRepository {
    ProductReturn findReturn();
    List<ProductQna> findQna(int pid);
    ProductDetailinfoDto findProductDetailinfo(int pid);
    ProductDto findByPid(int pid);
    List<ProductDto> findAll();
}
