package com.example.application.services.questionnaire;

import com.example.application.dto.QuestionnaireData;
import com.example.application.models.Client;
import com.example.application.models.questionnaire.Questionnaire;
import com.example.application.repositories.questionnaire.QuestionnaireRepository;
import com.example.application.services.ClientService;
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
    private ClientService clientService;
    private SectionsService sectionsService;

    public QuestionnaireService(QuestionnaireRepository questionnaireRepository,
                                ClientService clientService,
                                SectionsService sectionsService,
                                TelegramNotificationService telegramNotificationService) {
        this.questionnaireRepository = questionnaireRepository;
        this.clientService = clientService;
        this.sectionsService = sectionsService;
        this.telegramNotificationService = telegramNotificationService;
    }

    @Transactional
    public Questionnaire submitQuestionnaire(QuestionnaireData questionnaireData) {
        Client client = clientService.createAndPersistUser();
        Questionnaire questionnaire = createAndPersistQuestionnaire(client);

        sectionsService.findAndSaveQuestionnaireSections(questionnaire, questionnaireData);
        displayMessageAfterSubmissions(client.getEmail(), questionnaire.getId());
        return questionnaire;
    }

    private Questionnaire createAndPersistQuestionnaire(Client client) {
        Questionnaire questionnaire = new Questionnaire();
        questionnaire.setClient(client);
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
