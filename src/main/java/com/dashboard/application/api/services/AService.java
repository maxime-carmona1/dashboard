package com.dashboard.application.api.services;

import org.springframework.web.reactive.function.client.WebClient;

public abstract class AService {

    // Attributes 

    protected final WebClient webClient;

    // Constructors

    protected AService(WebClient.Builder builder, String url) {
        webClient = builder.baseUrl(url).build();
    }
}
