package com.nm.springwebclient.controller;

import com.nm.springwebclient.client.SearchClient;
import com.nm.springwebclient.model.Brewery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@CrossOrigin(value = {"http://localhost:3000"})
@RestController
public class SearchController {

    @Autowired
    private SearchClient searchClient;

    @Autowired
    private Environment environment;

    @GetMapping("/breweries")
    public Flux<Brewery> listBreweries() {
        log.info(environment.getProperty("breweries"));
        return searchClient.listBreweries();
    }

    // Add more enpoints for search and get brewery
    @GetMapping("/{id}")
    public Mono<Brewery> getBreweryById(@PathVariable Long id) {
        return searchClient.findBreweryById(id);
    }

    @GetMapping("{query}")
    public Flux<Brewery> searchBreweriesByQuery(@PathVariable String query) {
        return searchClient.findBreweriesByQuery(query);
    }

}
