package com.nm.springwebclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class SpringWebClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebClientApplication.class, args);
	}

}
