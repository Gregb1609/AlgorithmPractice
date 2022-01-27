package _3InsertionSort;

import java.util.Arrays;

public class InsertionSort {
	public static void main(String[] args) {
		int [] values = {20,35,-15,7,55,1,-22};
		System.out.println(Arrays.toString(values));
		sort(values);
		System.out.println(Arrays.toString(values));
	}
	//The insertion sort work on the principal of extending a sorted subarray with logic.  it starts by 
	//comparing index 1 with index 0. If 1>0 no change is made but if not index 0 is moved one index to the right.
	//since the value being compared has reached the end of the register the comparing value is dropped here 
	//and the size of the sorted sub-array is increased by 1. next index 2 is selected and moved left until 
	//it reaches a comparison where it is greater than the value OR it hits the zero position and is inserted.
	//Insertion is On(squared) time complexity due to nested loops but is in place and stable.
	public static int[] sort(int[] input) {
		for(int ordered = 1;ordered<input.length;ordered++) {//outer loop selects length of sorted sub-array
			int temp=input[ordered];//selects the value for comparison
			for(int pointer = ordered;pointer>0;pointer--) {//inner loop iterates through sorted sub array
				System.out.println(Arrays.toString(input));
				if(input[pointer]>=input[pointer-1]) {
					break;//if it finds a value greater than the comparison value it skips on 
				}else {
					input[pointer]=input[pointer-1];//else it drops the input in place
					input[pointer-1]=temp;
				}
			}
		}
		return input;
	}

}
