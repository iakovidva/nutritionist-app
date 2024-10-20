package com.example.application.services.questionnaire;

import com.example.application.repository.questionnaire.AnthropometricRepository;
import org.springframework.stereotype.Service;

@Service
public class AnthropometricService {

    private AnthropometricRepository anthropometricRepository;

    public AnthropometricService(AnthropometricRepository anthropometricRepository) {
        this.anthropometricRepository = anthropometricRepository;
    }
}
