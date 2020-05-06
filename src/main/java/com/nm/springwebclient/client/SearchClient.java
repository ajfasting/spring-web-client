package com.nm.springwebclient.client;

import com.nm.springwebclient.model.SearchProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;

@Service
public class SearchClient {
    private static final String BREWERIES_API_BASE_URL = "https://api.openbrewerydb.org";

    private final WebClient webClient;

    @Autowired
    public SearchClient(SearchProperties searchProperties) {
        this.webClient = WebClient.builder()
                .baseUrl(BREWERIES_API_BASE_URL)
                .build();
    }



    public Flux<SearchProperties> listBreweries() {
        return webClient.get()
               .exchange()
               .flatMapMany(clientResponse -> clientResponse.bodyToFlux(SearchProperties.class));
   }

}