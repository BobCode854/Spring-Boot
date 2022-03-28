package com.example.SpringWithDependencyInjection;


import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringWithDependencyInjectionApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SpringWithDependencyInjectionApplication.class, args);
		// In the last project If we have to change the sorting logic then we have to change the code of the Service.
		
		BinarySearchImpl binarySearch=new BinarySearchImpl(new QuickSortAlgorithm()); // we are providing object
		//we need some concept or a framework which will provide this object and help spring in getting full DI.
		
		int  result=binarySearch.binarySearch(new int[]{4, 6,3,8,1},4);
		// In this method our dependency is always on bubble sort
		//And for any other sorting algorithm to use we need to change application code.
		//Their should be some way to get rid of it.
		System.out.println(result);
	}

}
