package com.example.application.services.questionnaire;

import com.example.application.repository.questionnaire.AnthropometricRepository;
import com.vaadin.hilla.BrowserCallable;

@BrowserCallable
public class AnthropometricService {

    private AnthropometricRepository anthropometricRepository;

    public AnthropometricService(AnthropometricRepository anthropometricRepository) {
        this.anthropometricRepository = anthropometricRepository;
    }
}
