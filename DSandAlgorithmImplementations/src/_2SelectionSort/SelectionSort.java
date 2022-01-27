package _2SelectionSort;

import java.util.Arrays;

public class SelectionSort {
	//This sort progressively scans through the array finding the index of the largest value at each pass
	//at the end of the pass the value at the highest value index in the array is swapped with the highest
	//value.  The highest index that is scanned is then reduced by 1 so sorted values are not re-scanned.
	//has a On(squared) complexity due to nested loops. It is also in place but unstable.

	public static void main(String[] args) {
		int [] values = {20,35,-15,7,55,1,-22};
		System.out.println(Arrays.toString(values));
		sort(values);
		System.out.println(Arrays.toString(values));
	}
	
	public static int[] sort(int[]input) {
		for(int unsorted=input.length-1;unsorted>0;unsorted--) {//outer loop holds the drop position for the swap
			int highest = Integer.MIN_VALUE;
			for(int pointer=1;pointer<=unsorted;pointer++) {//inner loop iterates over values
				
				if(input[pointer]>input[highest]) {//statement swaps the pointer each time a larger value is found
					highest=pointer;
				}
			}
			swap(input,unsorted,highest);//call to swap the outer loop position with the max value
			System.out.println(Arrays.toString(input));
		}
		return input;
	}
	public static void swap(int[] array,int location,int end) {
		int temp = array[location];
		array[location]=array[end];
		array[end]=temp;
	}

}
