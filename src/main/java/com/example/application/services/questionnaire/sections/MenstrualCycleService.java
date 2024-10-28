package com.example.application.services.questionnaire.sections;

import com.example.application.models.questionnaire.MenstrualCycle;
import com.example.application.models.questionnaire.Questionnaire;
import com.example.application.repositories.questionnaire.sections.MenstrualCycleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MenstrualCycleService {

    private static final Logger log = LoggerFactory.getLogger(MenstrualCycleService.class);

    private MenstrualCycleRepository menstrualCycleRepository;

    public MenstrualCycleService(MenstrualCycleRepository menstrualCycleRepository) {
        this.menstrualCycleRepository = menstrualCycleRepository;
    }

    public void saveInfo(MenstrualCycle menstrualCycle, Questionnaire questionnaire) {
        if (menstrualCycle.getRegularMenstrualCycle() != null) {
            menstrualCycle.setQuestionnaire(questionnaire);
            menstrualCycleRepository.save(menstrualCycle);
            log.info("Saving {}", menstrualCycle);
        }
    }
}
