package com.backend.extraallt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Value("${openai.api.url}")
    String nonsecretKey;

    @Value("${openai.api.key}")
    String secretKey;

    @GetMapping
    public String getMethodName() {
        return "Icke hemlig nyckel: " + nonsecretKey + " HEMLIG NYCKEL: " + secretKey;
    }
}
