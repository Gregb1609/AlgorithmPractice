package _2SelectionSort;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int [] values = {20,35,-15,7,55,1,-22};
		System.out.println(Arrays.toString(values));
		sort(values);
		System.out.println(Arrays.toString(values));
	}
	
	public static int[] sort(int[]input) {
		for(int unsorted=input.length-1;unsorted>0;unsorted--) {
			int highest = 0;
			for(int pointer=0;pointer<unsorted;pointer++) {
				
				if(input[pointer]>input[highest]) {
					highest=pointer;
				}
			}
			swap(input,unsorted,highest);
		}
		return input;
	}
	public static void swap(int[] array,int location,int end) {
		int temp = array[location];
		array[location]=array[end];
		array[end]=temp;
	}

}
