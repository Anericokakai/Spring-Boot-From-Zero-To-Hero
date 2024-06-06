package com.ricodev.springbootsetup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication

public class SpringBootDependencyInjection {


	public static void main(String[] args) {

	 ConfigurableApplicationContext container= SpringApplication.run(SpringBootDependencyInjection.class, args);

/*
uncomment if you want to check the objects
 */
//	Arrays.asList(container.getBeanDefinitionNames()).forEach(System.out::println);
////	how to access an object
Car car=container.getBean(Car.class);
car.printCarStatus();
	}

}
