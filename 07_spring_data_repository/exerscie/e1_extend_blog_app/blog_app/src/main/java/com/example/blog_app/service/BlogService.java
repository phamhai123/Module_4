package com.example.blog_app.service;

import com.example.blog_app.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    Page<Blog> findAll(Pageable pageable,String searchName);
    Blog findById(int id);
    boolean deleteById(int id);
    boolean create(Blog blog);
    boolean update(int id, Blog blog);
}
