package com.example.application.services.questionnaire.sections;

import com.example.application.models.questionnaire.Demographic;
import com.example.application.models.questionnaire.Questionnaire;
import com.example.application.repositories.questionnaire.sections.DemographicRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DemographicService {

    private static final Logger log = LoggerFactory.getLogger(DemographicService.class);

    private DemographicRepository demographicRepository;

    public DemographicService(DemographicRepository demographicRepository) {
        this.demographicRepository = demographicRepository;
    }

    public void saveInfo(Demographic demographic, Questionnaire questionnaire) {
        demographic.setQuestionnaire(questionnaire);
        demographicRepository.save(demographic);
        log.info("Saving {}", demographic);
    }
}
