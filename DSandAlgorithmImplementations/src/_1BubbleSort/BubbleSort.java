package BubbleSort;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int [] values = {20,35,-15,7,55,1,-22};
		System.out.println(Arrays.toString(values));
		sort(values);
		System.out.println(Arrays.toString(values));

	}
	
	public static int[] sort(int[] input) {
		for(int unsorted=input.length-1;unsorted>0;unsorted--) {
			for(int i=0;i<unsorted;i++) {
				if(input[i]>input[i+1]) {
					swap(input,i,i+1);
				}
			}
			
		}
		return input;
	}
	
	public static void swap(int[] array, int i, int j) {
		int temp;
		temp = array[i];
		array[i] = array[j];
		array[j]=temp;
		return;
	}

}
