package com.example.application.services.questionnaire;

import com.example.application.repository.questionnaire.WorkAndMealScheduleRepository;
import com.vaadin.hilla.BrowserCallable;

@BrowserCallable
public class WorkAndMealScheduleService {

    private WorkAndMealScheduleRepository workAndMealScheduleRepository;

    public WorkAndMealScheduleService(WorkAndMealScheduleRepository workAndMealScheduleRepository) {
        this.workAndMealScheduleRepository = workAndMealScheduleRepository;
    }
}
