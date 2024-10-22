package com.example.application.services.questionnaire;

import com.example.application.repositories.questionnaire.MenstrualCycleRepository;
import org.springframework.stereotype.Service;

@Service
public class MenstrualCycleService {

    private MenstrualCycleRepository menstrualCycleRepository;

    public MenstrualCycleService(MenstrualCycleRepository menstrualCycleRepository) {
        this.menstrualCycleRepository = menstrualCycleRepository;
    }
}
