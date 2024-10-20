package com.example.application.services;

import com.example.application.repository.UserRepository;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hilla.BrowserCallable;
import com.vaadin.hilla.Endpoint;
import org.springframework.stereotype.Service;

//@BrowserCallable
//@Endpoint
//@AnonymousAllowed
@BrowserCallable
@AnonymousAllowed
@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String isAmethodNecessary() {
        return "ifGenerated -> Yes :)";
    }
}
