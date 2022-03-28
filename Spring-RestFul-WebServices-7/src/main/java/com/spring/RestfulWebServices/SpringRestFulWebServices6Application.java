package com.spring.RestfulWebServices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Extended version of Spring-RestFul-Webservices-6 
//Here  we will create ExceptionTemplate and GenericWay to deal with Excpetion at Controller Level
//Remember Its a ExceptionHandler but not Validator. We didnt Perform validation yet.

@SpringBootApplication
public class SpringRestFulWebServices6Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestFulWebServices6Application.class, args);
	}

}
