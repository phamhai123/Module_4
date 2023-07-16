package com.example.service;

import com.example.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    boolean add(Product product);
    Product findById(int id);
    boolean update(int id, Product product);
    boolean delete(int id);
}
