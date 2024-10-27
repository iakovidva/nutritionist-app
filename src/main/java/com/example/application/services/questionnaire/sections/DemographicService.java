package com.example.application.services.questionnaire.sections;

import com.example.application.models.questionnaire.Demographic;
import com.example.application.models.questionnaire.Questionnaire;
import com.example.application.repositories.questionnaire.sections.DemographicRepository;
import org.springframework.stereotype.Service;

@Service
public class DemographicService {

    private DemographicRepository demographicRepository;

    public DemographicService(DemographicRepository demographicRepository) {
        this.demographicRepository = demographicRepository;
    }

    public void saveInfo(Demographic demographic, Questionnaire questionnaire) {
        demographic.setQuestionnaire(questionnaire);
        demographicRepository.save(demographic);
        System.out.println("Saving + " + demographic);
    }
}
