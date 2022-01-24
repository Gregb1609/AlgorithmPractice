package _4ShellSort;

import java.util.Arrays;

public class ShellSort {
	
	//This sort is an optimisation of the insertion sort as it sorts in bigger chunks first which gives a roughly sorted list.
	//the final step is a bubble or insertion sort but because of the rough sorting its complexity can be reduced from Osquared to less...
	//the exact complexity depends on the size of the initial sort chunks and the math used to calculate the chunks.  Apparently the Knuth
	//sequence calculated here is a good bet but there are lots of schools of thought on wikipedia...
	
	public static void main(String[] args) {
		int [] values = {20,35,-15,7,55,1,-22};
		System.out.println(Arrays.toString(values));
		sort(values);
		System.out.println(Arrays.toString(values));
	}
	
	public static int[] sort(int[] input) {
		int knuth = (int) (Math.pow(3, input.length)-1)/2;
		if (knuth>input.length) {
			knuth=input.length/2;
		}
		for(int outer=knuth;outer>=1;outer/=2) {
			System.out.println("running");
			for(int sorted=outer;sorted<input.length;sorted++) {
				System.out.println("sorted");
				int pointer = sorted;
				int temp=input[sorted];
				//revised here according to course.  What I had written used more cycles as it didn't skip by gap correctly
				while(pointer>=outer&&input[pointer-outer]>temp) {
					input[pointer]=input[pointer-outer];
					System.out.println(outer+" "+sorted+" "+pointer);
					System.out.println(Arrays.toString(input));
					pointer-=outer;
					}
				input[pointer]=temp;
			}
		}
		return input;
	}

}
