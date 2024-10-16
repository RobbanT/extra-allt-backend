package com.backend.extraallt.config;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.context.annotation.*;

@Configuration
public class OpenAiRestTemplate {
    @Value("${openai.api.key}")
    private String apiKey;

    @Bean
    @Qualifier("openAiRestTemplate")

    public RestTemplate openaiRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add((request, body, execution) -> {
            request.getHeaders().add("Authorization", "Bearer " + apiKey);
            return execution.execute(request, body);
        });
        return restTemplate;
    }
}
