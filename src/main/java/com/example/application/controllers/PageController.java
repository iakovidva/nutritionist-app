package com.example.application.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    private static final String ACTIVE_PAGE_ATTR = "activePage";

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute(ACTIVE_PAGE_ATTR, "home");
        return "views/home";
    }

    @GetMapping("/features")
    public String features(Model model) {
        model.addAttribute(ACTIVE_PAGE_ATTR, "features");
        return "views/features";
    }

    @GetMapping("/pricing")
    public String pricing(Model model) {
        model.addAttribute(ACTIVE_PAGE_ATTR, "pricing");
        return "views/pricing";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute(ACTIVE_PAGE_ATTR, "about");
        return "views/about";
    }
}
