package com.example.spring_build.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Controller
public class Controller {
    private static String[] list = {"Lettuce","Tomato","Mustard","Sprouts"};
    @GetMapping("/")
    public String seasoning(Model model) {
        model.addAttribute("showList",list);
        return "index";
    }

    @GetMapping("/save")
    public String save(@RequestParam("condiment") String[] condiment,Model model) {
        model.addAttribute("showList",list);
        model.addAttribute("result",condiment);
        return "index";
    }
}
