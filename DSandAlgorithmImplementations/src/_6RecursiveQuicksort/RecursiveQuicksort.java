package _6RecursiveQuicksort;

import java.util.Arrays;

public class RecursiveQuicksort {

	public static void main(String[] args) {
		int[] values = { 20, 35, -15, 7, 55, 1, -22 };
		System.out.println(Arrays.toString(values));
		quickSort(values, 0, values.length);
		System.out.println(Arrays.toString(values));
	}

	public static int[] quickSort(int[] input, int start, int end) {
		if (end - start < 2) {
			return input;//this is our base case escape when this is true our 
			//logical arrays are only 1 digit in size.
		}
		int pivotIndex = partition(input, start, end);//this call does the sort 
		//for each recursive call

		quickSort(input, start, pivotIndex);//recursive call for left side of pivot
		quickSort(input, pivotIndex+1, end);//recursive call for right side
		
		return input;
	}

	public static int partition(int[] input, int start, int end) {
		// This method determines the point around which all other sorting is taking
		// place. It takes the first element of the array and compares it to other 
		//values. It has two pointers, one at the start and one at the end they 
		//bounce data between each other and take turns in incrementing until they
		// hit a value not right for their side. In this example j moves from the 
		//right and keeps moving until it finds a value less than the first value 
		//of the input. They also compare their relative values as when they cross the
		// array/sub-array has been sorted.
		int pivot = input[start];// find value for comparison
		int i = start;// left pointer rejects greater then pivot or moves right
		int j = end;// right pointer rejects less than pivot or moves left
		while (i < j) {//repeat until all values checked
			while (i < j && input[--j] >= pivot);// note no loop body just increment counter to move left
			if (i < j) {
				// if loop exits check if it is because all values have been checked. If not
				// swap values.
				input[i] = input[j];
			}
			// once a value swap happens switch pointers
			while (i < j && input[++i] <= pivot);// increment counter
			if (i < j) {
				// loop exits not due to all values checked so swap.
				input[j] = input[i];
			}
		}
		input[j]=pivot;//this drops the value that has been compared in to its correct index.
		return j;//once all values are checked the value of j when i moves past it 
		//the position in the array that the pivot value has been inserted to and
		//therefore the partition point for the next recursive call.

	}

}
