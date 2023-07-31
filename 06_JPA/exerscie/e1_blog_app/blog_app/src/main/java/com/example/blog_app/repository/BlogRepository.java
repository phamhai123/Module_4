package com.example.blog_app.repository;

import com.example.blog_app.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

    Blog deleteById(int id);
}
