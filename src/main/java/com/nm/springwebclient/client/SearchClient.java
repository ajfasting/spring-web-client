package com.nm.springwebclient.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.nm.springwebclient.model.Brewery;

import reactor.core.publisher.Flux;

@Service
public class SearchClient {
	
    @Autowired
    private Environment environment;

    public Flux<Brewery> listBreweries() {
    	final WebClient webClient = WebClient
    			.builder()
    			.baseUrl(environment.getProperty("breweries"))
    			.build();
    	
        return webClient
        		.get()
        		.exchange()
        		.flatMapMany(
        				clientResponse -> clientResponse.bodyToFlux(Brewery.class));
   }

}