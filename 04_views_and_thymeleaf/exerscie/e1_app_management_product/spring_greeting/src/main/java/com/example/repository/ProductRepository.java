package com.example.repository;

import com.example.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
    Product findById(int id);
    boolean add(Product product);
    boolean update(int id, Product product);
    boolean delete(int id);
}
