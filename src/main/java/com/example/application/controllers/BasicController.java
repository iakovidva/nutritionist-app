package com.example.application.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BasicController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "Hello world message! :) ");
        return "index";
    }

    @GetMapping("/bootstrap")
    public String bootStrap() {
        return "bootstrap-testing";
    }
}
