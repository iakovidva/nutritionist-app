package com.example.application.services.questionnaire;

import com.example.application.dto.QuestionnaireData;
import com.example.application.models.User;
import com.example.application.models.questionnaire.Questionnaire;
import com.example.application.repositories.questionnaire.QuestionnaireRepository;
import com.example.application.services.UserService;
import com.example.application.services.questionnaire.sections.SectionsService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class QuestionnaireService {

    private QuestionnaireRepository questionnaireRepository;
    private UserService userService;
    private SectionsService sectionsService;

    public QuestionnaireService(QuestionnaireRepository questionnaireRepository,
                                UserService userService,
                                SectionsService sectionsService) {
        this.questionnaireRepository = questionnaireRepository;
        this.userService = userService;
        this.sectionsService = sectionsService;
    }

    @Transactional
    public void submitQuestionnaire(QuestionnaireData questionnaireData) {
        User user = userService.createAndPersistUser();
        Questionnaire questionnaire = createAndPersistQuestionnaire(user);

        sectionsService.findAndSaveQuestionnaireSections(questionnaire, questionnaireData);
        displayMessageAfterSubmissions();
    }

    private Questionnaire createAndPersistQuestionnaire(User user) {
        Questionnaire questionnaire = new Questionnaire();
        questionnaire.setUser(user);
        questionnaire.setType(Questionnaire.QuestionnaireType.INITIAL);
        questionnaireRepository.save(questionnaire);
        System.out.println("Saving + " + questionnaire.getId());
        return questionnaire;
    }

    private void displayMessageAfterSubmissions() {
        System.out.println("------------------------------------------");
        System.out.println("Questionnaire submitted");
        System.out.println("------------------------------------------");
    }
}
