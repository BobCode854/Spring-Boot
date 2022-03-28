package com.example.SpringWithDependencyInjection;

import java.util.Arrays;

import org.springframework.stereotype.Component;
@Component
public class QuickSortAlgorithm implements SortingAlgorithm
{
@Override
	public int[] sort(int[] numbers) {
		
		 Arrays.sort(numbers);
		 return numbers;
	}
}
