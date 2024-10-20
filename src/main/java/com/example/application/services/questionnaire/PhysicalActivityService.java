package com.example.application.services.questionnaire;

import com.example.application.repository.questionnaire.PhysicalActivityRepository;
import org.springframework.stereotype.Service;

@Service
public class PhysicalActivityService {

    private PhysicalActivityRepository physicalActivityRepository;

    public PhysicalActivityService(PhysicalActivityRepository physicalActivityRepository) {
        this.physicalActivityRepository = physicalActivityRepository;
    }
}
