package com.example.image_of_date.repository;

import com.example.image_of_date.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Comment,Integer> {
}
