package com.example.application.services;

import com.example.application.repository.UserRepository;
import org.springframework.stereotype.Service;

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
