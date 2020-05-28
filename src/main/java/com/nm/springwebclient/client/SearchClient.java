package com.nm.springwebclient.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.nm.springwebclient.model.Brewery;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class SearchClient {

    @Autowired
    private WebClient webClient;
    
    public Flux<Brewery> listBreweries() {
        return this.webClient
        		.get()
        		.exchange()
        		.flatMapMany(
        				clientResponse -> clientResponse.bodyToFlux(Brewery.class));
   }

    public Mono<Brewery> findBreweryById(Long id) {
    	log.info(id.toString());
    	return webClient
        		.get()
        		.uri(uriBuilder -> uriBuilder
        				.path("/{id}")
        				.build(id))
        		.retrieve()
        		.bodyToMono(Brewery.class);
    }
}