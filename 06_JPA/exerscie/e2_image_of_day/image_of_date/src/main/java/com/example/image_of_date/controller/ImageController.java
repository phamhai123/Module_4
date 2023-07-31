package com.example.image_of_date.controller;

import com.example.image_of_date.model.Comment;
import com.example.image_of_date.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/image")
public class ImageController {
    @Autowired
    private ImageService service;
    @GetMapping("/index")
    public ModelAndView showIndex(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("comments",service.findAll());
        modelAndView.addObject("comment",new Comment());
        return modelAndView;
    }
    @PostMapping("/create")
    private String createComment(@ModelAttribute Comment comment,
                                 RedirectAttributes redirectAttributes){
        service.addComment(comment);
        return "redirect:/image/index";
    }
    @GetMapping("update/{id}")
    private String updateLike(@PathVariable int id){
        Comment comment = service.findById(id);
        service.updateLike(comment);
        return "redirect:/image/index";
    }
}
