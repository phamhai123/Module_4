package com.example.controller;

import com.example.model.Product;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService service;
    @GetMapping("/")
    public String product(Model model){
        model.addAttribute("products",service.findAll());
        return "index";
    }
    @GetMapping("create")
    public String showCreate(Model model){
        model.addAttribute("product",new Product());
        return "create";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute Product product, Model model, RedirectAttributes redirectAttributes){
        service.add(product);
        redirectAttributes.addAttribute("mess","Add success!");
        return "redirect:/product/";
    }
    @GetMapping("update/{id}")
    public String showUpdate(@PathVariable int id, Model model){
        Product product = service.findById(id);
        model.addAttribute("product",product);
        return "update";
    }
    @PostMapping("/update/{id}")
    public String update(@ModelAttribute Product product, Model model, RedirectAttributes redirectAttributes){
        service.update(product.getId(), product);
        redirectAttributes.addAttribute("mess","Update success!");
        return "redirect:/product/";
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable int id, Model model, RedirectAttributes redirectAttributes){
        service.delete(id);
        redirectAttributes.addAttribute("mess","Delete success!");
        return "redirect:/product/";
    }
}
