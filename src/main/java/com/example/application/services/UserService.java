package com.example.application.services;

import com.example.application.models.User;
import com.example.application.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import static com.example.application.utils.RandomStringGenerator.generateRandomString;

@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

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
        log.info("logger: Saving {}", user.getEmail());
        return user;
    }
}
