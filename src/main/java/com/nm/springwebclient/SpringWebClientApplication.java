package com.nm.springwebclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class SpringWebClientApplication {

	@Autowired
	private Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(SpringWebClientApplication.class, args);
	}

	@Bean
	public WebClient webClient() {
		return WebClient
    			.builder()
    			.baseUrl(environment.getProperty("breweries"))
    			.build();
	}
}
