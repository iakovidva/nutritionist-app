package com.example.application.controllers;

import com.example.application.dto.QuestionnaireData;
import com.example.application.enums.DietTypes;
import com.example.application.enums.Gender;
import com.example.application.enums.Goals;
import com.example.application.enums.WeeklyFrequency;
import com.example.application.models.questionnaire.Questionnaire;
import com.example.application.services.questionnaire.QuestionnaireService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
        return "views/questionnaire";
    }

    @PostMapping("/questionnaire/submit")
    public String handleSubmit(@ModelAttribute QuestionnaireData questionnaireData) {

        Questionnaire questionnaire = questionnaireService.submitQuestionnaire(questionnaireData);
        return "redirect:/questionnaire/" + questionnaire.getId() + "/submitted";
    }

    @GetMapping("/questionnaire/{questionnaireId}/submitted")
    public String showSubmittedPage(@PathVariable Long questionnaireId, Model model) {
        Questionnaire questionnaire = questionnaireService.findById(questionnaireId);

        String userName = "steve";
        //TODO: Check if the user has permission to view the submission page.
//        if (questionnaire == null || !questionnaire.getUser().equals(getCurrentUser())) {
//            return "redirect:/error"; // Redirect to an error page if not authorized.
//        }
        model.addAttribute("username", userName);
        model.addAttribute("questionnaire", questionnaire);
        return "views/questionnaire-submitted";
    }

}
