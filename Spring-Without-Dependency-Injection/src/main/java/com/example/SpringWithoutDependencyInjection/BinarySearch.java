package com.example.SpringWithoutDependencyInjection;

import java.util.Arrays;

//This way of searching we are always dependent on bubbleSortAlgorithm
//Later on If any best searching algo will come we have to change our application code.

public class BinarySearch
{
	// Sorting elements
	public int binarySearch(int arr[], int number) {
		int index = 1;
		// Sorting the element
		Arrays.sort(arr); // Suppose this is a bubble sort algorithm
		// searching the element
		for (int value : arr) {
			if (value == number)
				return index;
			else
				index++;
		}
		return 0;
	}
}

