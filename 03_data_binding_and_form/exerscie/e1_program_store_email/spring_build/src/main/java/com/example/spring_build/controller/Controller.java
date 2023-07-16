package com.example.spring_build.controller;

import com.example.spring_build.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Controller
@RequestMapping("/storeEmail")
public class Controller {
    private static String[] languages = {"English","Vietnamese","Japanese","Chinese"};
    private static int[] size = {5,10,15,20,25};
    @Autowired
    private StoreService service;
    @GetMapping("/")
    public String showList(Model model) {
        model.addAttribute("listStore",service.findAll());
        return "index";
    }

    @GetMapping("/showSave")
    public String showSave(Model model) {
        model.addAttribute("language",languages);
        model.addAttribute("size",size);
        return "create";
    }
    @GetMapping("/save")
    public String save(){

    }
}
