package _3InsertionSort;

import java.util.Arrays;

public class InsertionSort {
	public static void main(String[] args) {
		int [] values = {20,35,-15,7,55,1,-22};
		System.out.println(Arrays.toString(values));
		sort(values);
		System.out.println(Arrays.toString(values));
	}
	
	public static int[] sort(int[] input) {
		for(int ordered = 1;ordered<input.length;ordered++) {
			int temp=input[ordered];
			for(int pointer = ordered;pointer>0;pointer--) {
				if(input[pointer]>=input[pointer-1]) {
					break;
				}else {
					input[pointer]=input[pointer-1];
					input[pointer-1]=temp;
				}
			}
		}
		return input;
	}

}
