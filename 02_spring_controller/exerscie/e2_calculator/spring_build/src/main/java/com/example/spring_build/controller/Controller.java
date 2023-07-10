package com.example.spring_build.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Controller
public class Controller {
    private static Map<String, String> dictionaryList = new HashMap<>();

    static {
        dictionaryList.put("Dog", "Chó");
        dictionaryList.put("Cat", "Mèo");
        dictionaryList.put("Hot", "Nóng");
        dictionaryList.put("Tiger", "Sư tử");
    }

    @GetMapping("/")
    public String dictionary() {
        return "index";
    }

    @GetMapping("/dictionary")
    public String converter(@RequestParam String valueName, Model model) {
        String value = "";
        for (String text : dictionaryList.keySet()
        ) {
            if (text.toLowerCase().equals(valueName.toLowerCase())) {
                value = valueName + " : " + dictionaryList.get(text);
            }
        }

        model.addAttribute("result", value);
        return "index";
    }

}
