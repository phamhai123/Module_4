package com.example.blog_app.controller;

import com.example.blog_app.model.Blog;
import com.example.blog_app.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;


@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogService service;
    @GetMapping("")
    public ModelAndView showList(@RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "2") int size,
                                 @RequestParam()Optional<String> searchName){
        String searchNameValue = "";
        if(searchName.isPresent()){
            searchNameValue = searchName.get();
        }
        Pageable pageable = PageRequest.of(page,size, Sort.by("name").ascending().and(Sort.by("id").ascending()));
        Page<Blog> blogList = service.findAll(pageable,searchNameValue);
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("blogList",blogList);
        modelAndView.addObject("searchName",searchNameValue);
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public String deleteBlog(@PathVariable int id,
                             RedirectAttributes redirectAttributes){
        if(service.deleteById(id)){
            redirectAttributes.addFlashAttribute("mess","Blog deleted successfully");
        }else {
            redirectAttributes.addFlashAttribute("mess","Blog deletion failed");
        }
        return "redirect:/blog";
    }
    @GetMapping("create")
    public String showCreate(Model model){
        model.addAttribute("blog",new Blog());
        return "create";
    }
    @PostMapping("/create")
    public String save(@ModelAttribute Blog blog,
                       RedirectAttributes redirectAttributes){
        if(service.create(blog)){
            redirectAttributes.addFlashAttribute("mess","Blog create successfully");
        }else {
            redirectAttributes.addFlashAttribute("mess","Blog create failed");
        }
        return "redirect:/blog";
    }
    @GetMapping("/update/{id}")
    public String showUpdate(@PathVariable int id
                             ,Model model){
        model.addAttribute("blog",service.findById(id));
        return "update";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Blog blog,
                         RedirectAttributes redirectAttributes){
        service.update(blog.getId(),blog);
        return "redirect:/blog";
    }
}
