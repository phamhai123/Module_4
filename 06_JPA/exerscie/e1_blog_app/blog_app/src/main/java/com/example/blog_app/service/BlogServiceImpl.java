package com.example.blog_app.service;

import com.example.blog_app.model.Blog;
import com.example.blog_app.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService{
    @Autowired
    private BlogRepository repository;
    @Override
    public List<Blog> findAll() {
        return repository.findAll();
    }

    @Override
    public Blog findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteById(int id) {
        return repository.deleteById(id) == null;
    }

    @Override
    public boolean create(Blog blog) {
        return  repository.save(blog) == null;
    }

    @Override
    public boolean update(int id, Blog blog) {
        if(repository.existsById(id)){
            repository.save(blog);
            return true;
        }
        return false;
    }
}
