package com.nm.springwebclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nm.springwebclient.client.SearchClient;
import com.nm.springwebclient.model.Brewery;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
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
    
}