package com.ricodev.springbootsetup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//! EXAMPLE OF A SPRING ANNOTATION
@SpringBootApplication // it contains the three annotation
// @EnableAutoconfiguration @SpringConfiguration & @ComponentScan

public class HandlingHttpResponses {

//! SprignApplication.run ---> deligates our main method to springBootApplication
	public static void main(String[] args) {
		SpringApplication.run(HandlingHttpResponses.class, args);
	}

}
