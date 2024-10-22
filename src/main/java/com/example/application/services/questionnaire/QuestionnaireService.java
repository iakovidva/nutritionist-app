package com.example.application.services.questionnaire;

import com.example.application.repositories.questionnaire.QuestionnaireRepository;
import org.springframework.stereotype.Service;

@Service
public class QuestionnaireService {

    private QuestionnaireRepository questionnaireRepository;

    public QuestionnaireService(QuestionnaireRepository questionnaireRepository) {
        this.questionnaireRepository = questionnaireRepository;
    }

    public void submitQuestionnaire() {
        System.out.println("------------------------------------------");
        System.out.println("Questionnaire submitted");
        System.out.println("------------------------------------------");
    }
}
