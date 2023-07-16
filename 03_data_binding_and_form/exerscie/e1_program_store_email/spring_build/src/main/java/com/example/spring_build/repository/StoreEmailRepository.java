package com.example.spring_build.repository;

import com.example.spring_build.model.StoreEmail;

import java.util.List;

public interface StoreEmailRepository {
    List<StoreEmail> findAll();
    boolean add(StoreEmail storeEmail);
}
