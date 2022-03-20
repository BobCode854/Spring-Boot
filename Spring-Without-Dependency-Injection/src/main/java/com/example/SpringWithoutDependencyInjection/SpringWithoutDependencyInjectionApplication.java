package com.example.SpringWithoutDependencyInjection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringWithoutDependencyInjectionApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SpringWithoutDependencyInjectionApplication.class, args);
		BinarySearch binarySearch=new BinarySearch();
		int  result=binarySearch.binarySearch(new int[]{4, 6,3,8,1},3);
		// In this method our dependency is always on bubble sort
		//And for any other sorting algorithm to use we need to change application code.
		//Their should be some way to get rid of it.
		System.out.println(result);
		
	}

}
