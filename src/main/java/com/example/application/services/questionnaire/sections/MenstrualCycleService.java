package com.example.application.services.questionnaire.sections;

import com.example.application.models.questionnaire.MenstrualCycle;
import com.example.application.models.questionnaire.Questionnaire;
import com.example.application.repositories.questionnaire.sections.MenstrualCycleRepository;
import org.springframework.stereotype.Service;

@Service
public class MenstrualCycleService {

    private MenstrualCycleRepository menstrualCycleRepository;

    public MenstrualCycleService(MenstrualCycleRepository menstrualCycleRepository) {
        this.menstrualCycleRepository = menstrualCycleRepository;
    }

    public void saveInfo(MenstrualCycle menstrualCycle, Questionnaire questionnaire) {
        if (menstrualCycle.getRegularMenstrualCycle() != null) {
            menstrualCycle.setQuestionnaire(questionnaire);
            menstrualCycleRepository.save(menstrualCycle);
            System.out.println("Saving + " + menstrualCycle);
        }
    }
}
