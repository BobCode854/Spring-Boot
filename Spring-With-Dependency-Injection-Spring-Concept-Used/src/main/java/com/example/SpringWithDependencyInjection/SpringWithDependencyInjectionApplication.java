package com.example.SpringWithDependencyInjection;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/*
 *  In the Earlier 2 Projects
 *  --------------------------------
 *  Project -1 (Spring-Without-Dependency-Injection)
 *  -----------------------------------------------------------------
 *  We had seen like  What is the issue with Normal Java Flow were Coupling is needed.
 *  
 *  Project -2 (Spring-with-dependency-Injection-without-spring-concept)
 *  ----------------------------------------------------------------------------------
 *  In this Project we are mostly overcome with the issue coming in Project -1 but still In providing the
 *  object we are tightly coupled. 
 *  
 *  Moto : 
 *  ------------------------
 *  In this project we are trying to get rid of problem coming in Project 2 with Spring Concept.
 *  We will see How Spring helps in getting these tightly coupled object.
 *  
 *  We will Use annotation based configuration
 *  ---------------------------------------------------
 *  @Component @Primary
 *  
 *  
 *  
 *  Important Fact : 
 *  --------------------------
 *  Constructor and Setter both use autoWiring by type.
 *  
 *  
 */
@SpringBootApplication
public class SpringWithDependencyInjectionApplication 
{
     public static void main(String[] args)
	{
		ApplicationContext context=SpringApplication.run(SpringWithDependencyInjectionApplication.class, args);
		BinarySearchImpl bsI=context.getBean(BinarySearchImpl.class);
		int arr[]= {3,6,2,8,5};
		int number=3;
		int result=bsI.binarySearch(arr,number);
		System.out.println("Element position in the array after sorting is : "+result);
	}

}
