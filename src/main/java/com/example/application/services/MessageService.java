package com.example.application.services;

import com.example.application.model.questionnaire.DietaryPreferences;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hilla.BrowserCallable;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@ConfigurationProperties
@PropertySource("classpath:messages.properties")
@AnonymousAllowed
@BrowserCallable
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
