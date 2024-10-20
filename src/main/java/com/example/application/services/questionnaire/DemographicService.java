package com.example.application.services.questionnaire;

import com.example.application.repository.questionnaire.DemographicRepository;
import org.springframework.stereotype.Service;

@Service
public class DemographicService {

    private DemographicRepository demographicRepository;

    public DemographicService(DemographicRepository demographicRepository) {
        this.demographicRepository = demographicRepository;
    }
}
