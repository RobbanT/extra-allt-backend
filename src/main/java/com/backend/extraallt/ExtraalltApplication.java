package com.backend.extraallt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExtraalltApplication {

	@Value("${openai.api.url}")
	static String openaiApiUrl;

	public static void main(String[] args) {
		SpringApplication.run(ExtraalltApplication.class, args);
		System.out.println(openaiApiUrl);
	}

}
