package com.example.repository;

import com.example.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ProductRepositoryImpl implements ProductRepository{
    private static List<Product> productList = new ArrayList<>();
    static {
        productList.add(new Product(1,"Dien Thoai",20000,"Dien thoại giỏm","Iphone"));
        productList.add(new Product(2,"Dien Thoai",20000,"Dien thoại giỏm","Iphone"));
        productList.add(new Product(3,"Dien Thoai",20000,"Dien thoại giỏm","Iphone"));
    }
    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public Product findById(int id) {
        Product product = null;
        for (Product in: productList
             ) {
            if(in.getId() == id){
                product = in;
            }
        }
        return product;
    }

    @Override
    public boolean add(Product product) {
        return productList.add(product);
    }

    @Override
    public boolean update(int id, Product product) {
        int index = -1;
        int count = 0;
        for (Product in: productList
             ) {
            if (in.getId() == id){
                index = count;
                break;
            }
            count++;
        }
        productList.set(index,product);
        return false;
    }

    @Override
    public boolean delete(int id) {
        int index = -1;
        int count = 0;
        for (Product in: productList
        ) {
            if (in.getId() == id){
                index = count;
                break;
            }
            count++;
        }
        productList.remove(index);
        return false;
    }
}
