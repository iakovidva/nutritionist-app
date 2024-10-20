package com.example.application.services.questionnaire;

import com.example.application.repository.questionnaire.MenstrualCycleRepository;
import com.vaadin.hilla.BrowserCallable;

@BrowserCallable
public class MenstrualCycleService {

    private MenstrualCycleRepository menstrualCycleRepository;

    public MenstrualCycleService(MenstrualCycleRepository menstrualCycleRepository) {
        this.menstrualCycleRepository = menstrualCycleRepository;
    }
}
