package com.example.application.services.questionnaire;

import com.example.application.repository.questionnaire.QuestionnaireRepository;
import com.vaadin.hilla.BrowserCallable;

@BrowserCallable
public class QuestionnaireService {

    private QuestionnaireRepository questionnaireRepository;

    public QuestionnaireService(QuestionnaireRepository questionnaireRepository) {
        this.questionnaireRepository = questionnaireRepository;
    }
}
