package com.example.application.services;

import com.example.application.models.User;
import com.example.application.repositories.UserRepository;
import org.springframework.stereotype.Service;

import static com.example.application.utils.RandomStringGenerator.generateRandomString;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createAndPersistUser() {
        User user = new User();
        user.setEmail(generateRandomString() + "@gmail.com");
        user.setPassword("passwd" + generateRandomString());
        user.setRole(User.Role.CLIENT);
        userRepository.save(user);
        System.out.println("Saving + " + user.getEmail());
        return user;
    }
}
