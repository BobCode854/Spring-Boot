package com.example.SpringWithDependencyInjection;

import java.util.Arrays;

//This way of searching we are always dependent on bubbleSortAlgorithm
//Later on If any best searching algo will come we have to change our application code.

public class BinarySearchImpl
{
	private SortingAlgorithm sortingalgoName;
	
	
	public BinarySearchImpl(SortingAlgorithm sortingalgoName) {
		this.sortingalgoName = sortingalgoName;
	}


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

