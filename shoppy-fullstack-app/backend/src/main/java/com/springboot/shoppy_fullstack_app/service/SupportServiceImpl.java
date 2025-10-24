package com.springboot.shoppy_fullstack_app.service;

import com.springboot.shoppy_fullstack_app.dto.Support;
import com.springboot.shoppy_fullstack_app.repository.SupportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SupportServiceImpl implements SupportService{

    private SupportRepository supportRepository;

    @Autowired
    public SupportServiceImpl(SupportRepository supportRepository) {
        this.supportRepository = supportRepository;
    }

    @Override
    public List<Support> findAll() {
        return supportRepository.findAll();
    }
}
