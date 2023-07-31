package com.example.image_of_date.service;

import com.example.image_of_date.model.Comment;

import java.util.List;

public interface ImageService {
    List<Comment> findAll();
    Comment findById(int id);
    boolean addComment(Comment comment);
    boolean updateLike(Comment comment);
}
