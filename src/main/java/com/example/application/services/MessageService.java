package com.example.application.services;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@ConfigurationProperties
@PropertySource("classpath:messages.properties")
@Service
public class MessageService {

    @Value("${msg.dietaryPreferences.avoidedFoods}")
    private String avoidedFoods;

    @PostConstruct
    public void messageServiceMessage() {
        System.out.println("The message service is initialized and it has: ");
        System.out.println(avoidedFoods);
    }

    public String getAvoidedFoods() {
        return avoidedFoods;
    }
}
