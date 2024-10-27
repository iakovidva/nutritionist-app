package com.example.application.controllers;

import com.example.application.dto.QuestionnaireData;
import com.example.application.enums.DietTypes;
import com.example.application.enums.Gender;
import com.example.application.enums.Goals;
import com.example.application.enums.WeeklyFrequency;
import com.example.application.models.User;
import com.example.application.models.questionnaire.Questionnaire;
import com.example.application.services.UserService;
import com.example.application.services.questionnaire.QuestionnaireService;
import com.example.application.services.questionnaire.sections.SectionsService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class QuestionnaireController {

    private UserService userService;
    private QuestionnaireService questionnaireService;
    private SectionsService sectionsService;


    public QuestionnaireController(QuestionnaireService questionnaireService,
                                   UserService userService,
                                   SectionsService sectionsService) {
        this.questionnaireService = questionnaireService;
        this.userService = userService;
        this.sectionsService = sectionsService;
    }

    @GetMapping("/questionnaire")
    public String showQuestionnaire(Model model) {
        model.addAttribute("questionnaireData", new QuestionnaireData());
        model.addAttribute("genderOptions", Gender.values());
        model.addAttribute("weeklyFrequencyOptions", WeeklyFrequency.values());
        model.addAttribute("dietTypeOptions", DietTypes.values());
        model.addAttribute("nutritionGoalsOptions", Goals.values());
        model.addAttribute("currentStep", 1);
        return "questionnaire";
    }

    @PostMapping("/questionnaire/submit")
    @Transactional
    public String submitQuestionnaire(@ModelAttribute QuestionnaireData questionnaireData) {
        User user = userService.createAndPersistUser();
        Questionnaire questionnaire = questionnaireService.createAndPersistQuestionnaire(user);

        sectionsService.findAndSaveQuestionnaireSections(questionnaire, questionnaireData);

        questionnaireService.submitQuestionnaire();
        // After processing, redirect to a success page or show a success message
        return "redirect:/submitted";
    }

    @GetMapping("/submitted")
    public String submitted() {
        return "questionnaire-submitted";
    }

}
