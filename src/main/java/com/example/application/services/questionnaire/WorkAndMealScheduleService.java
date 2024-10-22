package com.example.application.services.questionnaire;

import com.example.application.repositories.questionnaire.WorkAndMealScheduleRepository;
import org.springframework.stereotype.Service;

@Service
public class WorkAndMealScheduleService {

    private WorkAndMealScheduleRepository workAndMealScheduleRepository;

    public WorkAndMealScheduleService(WorkAndMealScheduleRepository workAndMealScheduleRepository) {
        this.workAndMealScheduleRepository = workAndMealScheduleRepository;
    }
}
