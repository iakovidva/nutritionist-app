package com.example.application.services;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@ConfigurationProperties
@PropertySource("classpath:messages.properties")
@Service
public class MessageService {

    private static final Logger log = LoggerFactory.getLogger(MessageService.class);

    @Value("${msg.dietaryPreferences.avoidedFoods}")
    private String avoidedFoods;

    @PostConstruct
    public void messageServiceMessage() {
        log.info("The message service is initialized and it has: ");
        log.info(avoidedFoods);
    }

    public String getAvoidedFoods() {
        return avoidedFoods;
    }
}
