package com.example.application.controllers;

import com.example.application.dto.QuestionnaireData;
import com.example.application.enums.DietTypes;
import com.example.application.enums.Gender;
import com.example.application.enums.Goals;
import com.example.application.enums.WeeklyFrequency;
import com.example.application.services.questionnaire.QuestionnaireService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class QuestionnaireController {

    private QuestionnaireService questionnaireService;

    public QuestionnaireController(QuestionnaireService questionnaireService) {
        this.questionnaireService = questionnaireService;
    }

    @GetMapping("/questionnaire")
    public String showQuestionnaire(Model model) {
        model.addAttribute("questionnaireData", new QuestionnaireData());
        model.addAttribute("genderOptions", Gender.values());
        model.addAttribute("weeklyFrequencyOptions", WeeklyFrequency.values());
        model.addAttribute("dietTypeOptions", DietTypes.values());
        model.addAttribute("nutritionGoalsOptions", Goals.values());
        model.addAttribute("currentStep", 1);
        return "questionnaire.html";
    }

    @PostMapping("/questionnaire/submit")
    public String submitQuestionnaire(@ModelAttribute QuestionnaireData questionnaireData) {
        // Handle saving the submitted data here (e.g., saving to the database)
        // You may need to use services and repositories for this.
        questionnaireService.submitQuestionnaire();
        // After processing, redirect to a success page or show a success message
        return "redirect:/";
    }
}
