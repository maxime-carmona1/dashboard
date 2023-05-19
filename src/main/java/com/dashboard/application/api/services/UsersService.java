package com.dashboard.application.api.services;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.dashboard.application.api.rest.User;

 

@Service
public class UsersService extends AService {

    public UsersService(WebClient.Builder builder) {
        super(builder, "https://jsonplaceholder.typicode.com/");
    }

    public User[] getUsers() {
        return webClient
                    .get()
                    .uri("/users")
                    .retrieve()
                    .bodyToMono(User[].class).block();
    }
    
}
