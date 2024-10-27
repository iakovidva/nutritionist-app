package com.example.application.services.questionnaire.sections;

import com.example.application.models.questionnaire.Questionnaire;
import com.example.application.models.questionnaire.WorkAndMealSchedule;
import com.example.application.repositories.questionnaire.sections.WorkAndMealScheduleRepository;
import org.springframework.stereotype.Service;

@Service
public class WorkAndMealScheduleService {

    private WorkAndMealScheduleRepository workAndMealScheduleRepository;

    public WorkAndMealScheduleService(WorkAndMealScheduleRepository workAndMealScheduleRepository) {
        this.workAndMealScheduleRepository = workAndMealScheduleRepository;
    }

    public void saveInfo(WorkAndMealSchedule workAndMealSchedule) {
        System.out.println("Saving + " + workAndMealSchedule);
    }

    public void saveInfo(WorkAndMealSchedule workAndMealSchedule, Questionnaire questionnaire) {
        workAndMealSchedule.setQuestionnaire(questionnaire);
        workAndMealScheduleRepository.save(workAndMealSchedule);
        System.out.println("Saving + " + workAndMealSchedule);
    }
}
