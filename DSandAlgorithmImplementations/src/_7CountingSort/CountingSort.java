package _7CountingSort;

import java.util.Arrays;

public class CountingSort {

	public static void main(String[] args) {
		//In this sort we must make some assumptions about the data which allows us to get an O(n)
		//complexity.  In this case we need to know the range of values. The actual values in the
		//array are adjusted by the code though.
		int[] values = { 8,4,2,3,10,4,2,6,9,1};
		System.out.println(Arrays.toString(values));
		countSort(values,10);
		System.out.println(Arrays.toString(values));
	}
	
	public static int[] countSort(int[] input,int maxVal) {
		
		int[] counter=new int[maxVal];
		for(int i =0;i<input.length;i++) {
			//First iteration adds a tally to the counter index that relates to the value of the input index
			//we have had to create the array so not "in place".
			counter[input[i]-1]++;
		}
		int location=0;
		System.out.println(Arrays.toString(counter));
		for(int i=0;i<counter.length;i++) {
			//the for loop iterates us through the array of counts
			while(counter[i]>0) {
				//the while loop adds a value to the input array for each tally in the counter index
				//it decreases the number of tallys with each iteration and increases the value of the position
				//where the next value will be put in to the return array.
				input[location]=i+1;
				counter[i]--;
				location++;
			}
		}
		return input;
	}

}
