package com.example.spring_build.service;

import com.example.spring_build.model.StoreEmail;

import java.util.List;

public interface StoreService {
    List<StoreEmail> findAll();
    boolean add(StoreEmail storeEmail);
}
