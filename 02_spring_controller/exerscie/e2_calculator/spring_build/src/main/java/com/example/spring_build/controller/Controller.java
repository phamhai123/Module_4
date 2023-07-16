package com.example.spring_build.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/")
    public String calculator() {
        return "index";
    }

    @GetMapping("/calculator")
    public String converter(@RequestParam int valueFirst, @RequestParam String subtend, @RequestParam int valueEnd, Model model) {
        int result = 0;
        switch (subtend){
            case "+":
                result = valueFirst + valueEnd;
                break;
            case "-":
                result = valueFirst - valueEnd;
                break;
            case "*":
                result = valueFirst * valueEnd;
                break;
            case "/":
                result = valueFirst / valueEnd;
                break;
        }
        model.addAttribute("result",valueFirst + " " +  subtend + " " + valueEnd +" = " + result);
        return "index";
    }

}
