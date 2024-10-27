package com.example.application.telegram;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TelegramNotificationService {

    private final RestTemplate restTemplate;
    private final String botToken;
    private final String chatId;

    public TelegramNotificationService(RestTemplate restTemplate,
                                       @Value("${telegram.bot.token}") String botToken,
                                       @Value("${telegram.chat.id}") String chatId) {
        this.restTemplate = restTemplate;
        this.botToken = botToken;
        this.chatId = chatId;
    }

    public void sendMessage(String message) {
        String telegramApiUrl = "https://api.telegram.org/bot" + botToken + "/sendMessage";
        String requestUrl = telegramApiUrl + "?chat_id=" + chatId + "&text=" + message;
        restTemplate.getForObject(requestUrl, String.class);
    }
}
