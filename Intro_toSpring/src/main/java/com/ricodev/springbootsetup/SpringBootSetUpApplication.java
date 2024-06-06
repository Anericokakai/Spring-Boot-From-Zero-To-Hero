package com.ricodev.springbootsetup;

import com.fasterxml.jackson.core.JsonToken;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication

public class SpringBootSetUpApplication {


	public static void main(String[] args) {

	 ConfigurableApplicationContext container= SpringApplication.run(SpringBootSetUpApplication.class, args);

/*
uncomment if you want to check the objects
 */
//	Arrays.asList(container.getBeanDefinitionNames()).forEach(System.out::println);
////	how to access an object
Car car=container.getBean(Car.class);
car.printCarStatus();
	}

}
