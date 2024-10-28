package com.example.application.services.questionnaire.sections;

import com.example.application.models.questionnaire.PhysicalActivity;
import com.example.application.models.questionnaire.Questionnaire;
import com.example.application.repositories.questionnaire.sections.PhysicalActivityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PhysicalActivityService {

    private static final Logger log = LoggerFactory.getLogger(PhysicalActivityService.class);

    private PhysicalActivityRepository physicalActivityRepository;

    public PhysicalActivityService(PhysicalActivityRepository physicalActivityRepository) {
        this.physicalActivityRepository = physicalActivityRepository;
    }

    public void saveInfo(PhysicalActivity physicalActivity, Questionnaire questionnaire) {
        physicalActivity.setQuestionnaire(questionnaire);
        physicalActivityRepository.save(physicalActivity);
        log.info("Saving {}", physicalActivity);
    }
}
