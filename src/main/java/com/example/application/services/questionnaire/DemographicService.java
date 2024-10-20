package com.example.application.services.questionnaire;

import com.example.application.repository.questionnaire.DemographicRepository;
import com.vaadin.hilla.BrowserCallable;

@BrowserCallable
public class DemographicService {

    private DemographicRepository demographicRepository;

    public DemographicService(DemographicRepository demographicRepository) {
        this.demographicRepository = demographicRepository;
    }
}
