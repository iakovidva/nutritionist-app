package com.example.application.services.questionnaire;

import com.example.application.models.User;
import com.example.application.models.questionnaire.Questionnaire;
import com.example.application.repositories.questionnaire.QuestionnaireRepository;
import org.springframework.stereotype.Service;

@Service
public class QuestionnaireService {

    private QuestionnaireRepository questionnaireRepository;

    public QuestionnaireService(QuestionnaireRepository questionnaireRepository) {
        this.questionnaireRepository = questionnaireRepository;
    }

    public Questionnaire createAndPersistQuestionnaire(User user) {
        Questionnaire questionnaire = new Questionnaire();
        questionnaire.setUser(user);
        questionnaire.setType(Questionnaire.QuestionnaireType.INITIAL);
        questionnaireRepository.save(questionnaire);
        System.out.println("Saving + " + questionnaire.getId());
        return questionnaire;
    }

    public void submitQuestionnaire() {
        System.out.println("------------------------------------------");
        System.out.println("Questionnaire submitted");
        System.out.println("------------------------------------------");
    }
}
