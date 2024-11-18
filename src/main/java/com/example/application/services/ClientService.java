package com.example.application.services;

import com.example.application.models.Client;
import com.example.application.repositories.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import static com.example.application.utils.RandomStringGenerator.generateRandomString;

@Service
public class ClientService {

    private static final Logger log = LoggerFactory.getLogger(ClientService.class);

    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client createAndPersistUser() {
        Client client = new Client();
        client.setEmail(generateRandomString() + "@gmail.com");
        client.setPassword("passwd" + generateRandomString());
        clientRepository.save(client);
        log.info("logger: Saving {}", client.getEmail());
        return client;
    }
}
