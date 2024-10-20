package com.example.application.services.questionnaire;

import com.example.application.repository.questionnaire.QuestionnaireRepository;
import org.springframework.stereotype.Service;

@Service
public class QuestionnaireService {

    private QuestionnaireRepository questionnaireRepository;

    public QuestionnaireService(QuestionnaireRepository questionnaireRepository) {
        this.questionnaireRepository = questionnaireRepository;
    }
}
