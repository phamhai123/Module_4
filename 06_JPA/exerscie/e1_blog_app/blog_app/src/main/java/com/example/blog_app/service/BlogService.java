package com.example.blog_app.service;

import com.example.blog_app.model.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();
    Blog findById(int id);
    boolean deleteById(int id);
    boolean create(Blog blog);
    boolean update(int id, Blog blog);
}
