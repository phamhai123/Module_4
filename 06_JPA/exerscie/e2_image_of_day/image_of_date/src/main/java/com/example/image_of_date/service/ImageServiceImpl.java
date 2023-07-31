package com.example.image_of_date.service;

import com.example.image_of_date.model.Comment;
import com.example.image_of_date.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ImageServiceImpl implements ImageService{
    @Autowired
    private ImageRepository repository;
    @Override
    public List<Comment> findAll() {
        return repository.findAll();
    }

    @Override
    public Comment findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public boolean addComment(Comment comment) {
        return repository.save(comment) == null;
    }

    @Override
    public boolean updateLike(Comment comment) {
        if(repository.existsById(comment.getId())){
            comment.setLikeCount(comment.getLikeCount()+1);
            repository.save(comment);
            return true;
        }
        return false;
    }

}
