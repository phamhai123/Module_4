package com.example.spring_build.service;

import com.example.spring_build.model.StoreEmail;
import com.example.spring_build.repository.StoreEmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StoreServiceImpl implements StoreService{
    @Autowired
    private StoreEmailRepository repository;
    @Override
    public List<StoreEmail> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean add(StoreEmail storeEmail) {
        return repository.add(storeEmail);
    }
}
