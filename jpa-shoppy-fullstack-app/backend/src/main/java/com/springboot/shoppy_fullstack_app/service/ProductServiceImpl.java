package com.springboot.shoppy_fullstack_app.service;

import com.springboot.shoppy_fullstack_app.dto.ProductDto;
import com.springboot.shoppy_fullstack_app.dto.ProductDetailinfo;
import com.springboot.shoppy_fullstack_app.dto.ProductQna;
import com.springboot.shoppy_fullstack_app.dto.ProductReturn;
import com.springboot.shoppy_fullstack_app.entity.Product;
import com.springboot.shoppy_fullstack_app.jpa_repository.JpaProductRepository;
import com.springboot.shoppy_fullstack_app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
//@Transactional
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final JpaProductRepository jpaProductRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository,
                              JpaProductRepository jpaProductRepository) {
        this.productRepository = productRepository;
        this.jpaProductRepository = jpaProductRepository;
    }

    @Override
    public ProductReturn findReturn() { return productRepository.findReturn(); }

    @Override
    public List<ProductQna> findQna(int pid) {
        return productRepository.findQna(pid);
    }

    @Override
    public ProductDetailinfo findDetailinfo(int pid) {
        return productRepository.findProductDetailinfo(pid);
    }

    @Override
    public ProductDto findByPid(int pid) {
        return productRepository.findByPid(pid);
    }

    @Override
    public List<ProductDto> findAll() {
        List<ProductDto> dlist = new ArrayList<>();
        List<Product> list = jpaProductRepository.findAll();
        list.forEach((product) -> dlist.add(new ProductDto(product)));
        return dlist;
    }
}
