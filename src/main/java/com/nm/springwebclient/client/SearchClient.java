package com.nm.springwebclient.client;

import com.nm.springwebclient.model.Brewery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

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
                .header("Origin", "http://localhost:3000")
                .exchange()
                .flatMapMany(clientResponse -> clientResponse.bodyToFlux(Brewery.class));
   }

    public Mono<Brewery> findBreweryById(Long id) {
        log.info(id.toString());
        return webClient
                .get()
                .uri(uriBuilder -> uriBuilder.path("/{id}").build(id))
                .header("Origin", "http://localhost:3000")
                .retrieve()
                .bodyToMono(Brewery.class);
   }

   public Flux<Brewery> findBreweriesByQuery(String query) {
    log.info(query.toString());
    return this.webClient
            .get()
            .uri(uriBuilder -> uriBuilder.path("/search?query={query}").build(query))
            .header("Origin", "http://localhost:3000")
            .retrieve()
            .bodyToFlux(Brewery.class);
   }

}