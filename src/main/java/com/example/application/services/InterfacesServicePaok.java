package com.example.application.services;

import com.example.application.model.questionnaire.DietaryPreferences;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hilla.BrowserCallable;
import org.springframework.stereotype.Service;

@BrowserCallable
@AnonymousAllowed
@Service
public class InterfacesServicePaok {
    public DietaryPreferences getDietaryPreferences() {
        return new DietaryPreferences();
    }
}
