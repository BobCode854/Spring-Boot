package com.example.SpringWithDependencyInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//This way of searching we are always dependent on bubbleSortAlgorithm
//Later on If any best searching algo will come we have to change our application code.

@Service
public class BinarySearchImpl
{
	@Autowired
	private SortingAlgorithm sortingalgoName;  //1
	
	/*
	private SortingAlgorithm sortingalgoName; 
	
	------------------------2nd way-----------------------------------
	public BinarySearchImpl(SortingAlgorithm sortingalgoName) {
		this.sortingalgoName = sortingalgoName;
	}
	*/
	
	/*-----------------3rd way----------------------------------
	public void setSortingalgoName(SortingAlgorithm sortingalgoName) {
		this.sortingalgoName = sortingalgoName;
	}
	*/

	
	// we can use both 1 and 3 both will  give dependent object through setter injection itself
	// by 2nd way we will get object through Constructor Injection.


	// Sorting elements
	public int binarySearch(int arr[], int number) 
	{
		int index = 1;
		// Sorting the element
		sortingalgoName.sort(arr); // this way making sorting logic out of the main class.
		System.out.println("Sorting algo Name : "+this.sortingalgoName);
		// searching the element
		for (int value : arr) {
			if (value == number)
				//returning the index of the searched element
				return index;
			else
				index++;
		}
		//returning the index of the searched element
		return 0;
	}

	
}

