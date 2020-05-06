package com.nm.springwebclient.controller;

import com.nm.springwebclient.client.SearchClient;
import com.nm.springwebclient.model.SearchProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class SearchController {

    @Autowired
    private SearchClient searchClient;



    @GetMapping("/breweries")
    public Flux<SearchProperties> listBreweries() {
        return searchClient.listBreweries();
    }
    
}