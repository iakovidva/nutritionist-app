package com.example.application.services.questionnaire;

import com.example.application.dto.QuestionnaireData;
import com.example.application.models.User;
import com.example.application.models.questionnaire.Questionnaire;
import com.example.application.repositories.questionnaire.QuestionnaireRepository;
import com.example.application.services.UserService;
import com.example.application.services.questionnaire.sections.SectionsService;
import com.example.application.telegram.TelegramNotificationService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class QuestionnaireService {

    private TelegramNotificationService telegramNotificationService;
    private QuestionnaireRepository questionnaireRepository;
    private UserService userService;
    private SectionsService sectionsService;

    public QuestionnaireService(QuestionnaireRepository questionnaireRepository,
                                UserService userService,
                                SectionsService sectionsService,
                                TelegramNotificationService telegramNotificationService) {
        this.questionnaireRepository = questionnaireRepository;
        this.userService = userService;
        this.sectionsService = sectionsService;
        this.telegramNotificationService = telegramNotificationService;
    }

    @Transactional
    public void submitQuestionnaire(QuestionnaireData questionnaireData) {
        User user = userService.createAndPersistUser();
        Questionnaire questionnaire = createAndPersistQuestionnaire(user);

        sectionsService.findAndSaveQuestionnaireSections(questionnaire, questionnaireData);
        displayMessageAfterSubmissions(user.getEmail(), questionnaire.getId());
    }

    private Questionnaire createAndPersistQuestionnaire(User user) {
        Questionnaire questionnaire = new Questionnaire();
        questionnaire.setUser(user);
        questionnaire.setType(Questionnaire.QuestionnaireType.INITIAL);
        questionnaireRepository.save(questionnaire);
        System.out.println("Saving + " + questionnaire.getId());
        return questionnaire;
    }

    private void displayMessageAfterSubmissions(String userEmail, Long questionnaireId) {
        System.out.println("------------------------------------------");
        System.out.println("Questionnaire submitted");
        System.out.println("------------------------------------------");
        telegramNotificationService.sendMessage(String.format("User with email %s submitted the questionnaire no. %s", userEmail, questionnaireId));
    }
}
