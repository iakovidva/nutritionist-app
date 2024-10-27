package com.example.application.controllers;

import com.example.application.telegram.TelegramNotificationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BasicController {

    private final TelegramNotificationService telegramNotificationService;

    public BasicController(TelegramNotificationService telegramNotificationService) {
        this.telegramNotificationService = telegramNotificationService;
    }


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "Hello world message! :) ");
        return "index";
    }

    @GetMapping("/bootstrap")
    public String bootStrap() {
        return "bootstrap-testing";
    }

    @GetMapping("/sendMessage/{message}")
    public String sendMessage(@PathVariable String message) {
        telegramNotificationService.sendMessage(message);
        return "redirect:/";
    }
}
