package com.example.application.services.questionnaire;

import com.example.application.dto.QuestionnaireData;
import com.example.application.models.User;
import com.example.application.models.questionnaire.Questionnaire;
import com.example.application.repositories.questionnaire.QuestionnaireRepository;
import com.example.application.services.UserService;
import com.example.application.services.questionnaire.sections.SectionsService;
import com.example.application.telegram.TelegramNotificationService;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class QuestionnaireService {

    private static final Logger log = LoggerFactory.getLogger(QuestionnaireService.class);

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
    public Questionnaire submitQuestionnaire(QuestionnaireData questionnaireData) {
        User user = userService.createAndPersistUser();
        Questionnaire questionnaire = createAndPersistQuestionnaire(user);

        sectionsService.findAndSaveQuestionnaireSections(questionnaire, questionnaireData);
        displayMessageAfterSubmissions(user.getEmail(), questionnaire.getId());
        return questionnaire;
    }

    private Questionnaire createAndPersistQuestionnaire(User user) {
        Questionnaire questionnaire = new Questionnaire();
        questionnaire.setUser(user);
        questionnaire.setType(Questionnaire.QuestionnaireType.INITIAL);
        questionnaireRepository.save(questionnaire);
        log.info("Saving {}", questionnaire.getId());
        return questionnaire;
    }

    private void displayMessageAfterSubmissions(String userEmail, Long questionnaireId) {
        log.info("------------------------------------------");
        log.info("Questionnaire submitted");
        log.info("------------------------------------------");
        telegramNotificationService.sendMessage(String.format("User with email %s submitted the questionnaire no. %s", userEmail, questionnaireId));
    }

    public Questionnaire findById(Long questionnaireId) {
        return Optional.of(questionnaireRepository.findById(questionnaireId))
                .get()
                .orElseThrow(() -> new RuntimeException("QuestionnaireId doesn't exist"));
    }
}
