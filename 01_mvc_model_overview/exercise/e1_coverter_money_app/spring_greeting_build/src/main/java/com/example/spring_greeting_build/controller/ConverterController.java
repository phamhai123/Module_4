package com.example.spring_greeting_build.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConverterController {
    @GetMapping("/")
    public String greeting() {
        return "index";
    }
    @GetMapping("/converter")
    public String converter(@RequestParam double converter,Model model){
        double number = converter/23000;
        String alterNumber = number + " Dollar";
        model.addAttribute("result",alterNumber);
        return "index";
    }

}
