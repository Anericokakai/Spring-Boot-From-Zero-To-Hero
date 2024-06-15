package com.d3f4ult.jpa.config;

import com.d3f4ult.jpa.model.Client;
import com.d3f4ult.jpa.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RunApp {
    @Bean
    CommandLineRunner commandLineRunner(ClientRepository clientRepository){
        return args -> {
var client= Client.builder()
        .age(20)
        .email("anericokakai@gmail.com")
        .firstName("Anerico")
        .lastname("Kakai")
        .build();
clientRepository.save(client);
        };
    }
}
