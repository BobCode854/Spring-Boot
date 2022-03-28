package com.spring.FirstRestServices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
 * ------------------Spring Rest Services --------------------------------------------
 *
 * 1)  Spring Boot Starter Web is Required for Rest Services and web-application
 * 2) With @SpringBootApplication annotation Three things happen in background
 * 
 *      2.a)  @SpringBootConfiguration 
 *      2.b)  @EnableAutoConfiguration
 *      2.c)  @ComponentScan
 * 
 * 
 */
@SpringBootApplication
public class FirstRestServices4Application {

	public static void main(String[] args)
	{
		SpringApplication.run(FirstRestServices4Application.class, args);
	}

}
