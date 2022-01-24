package _5RecursiveMerge;

import java.util.Arrays;

public class RecursiveMerge {

	public static void main(String[] args) {
		int [] values = {20,35,-15,7,55,1,-22};
		System.out.println(Arrays.toString(values));
		mergeSort(values,0,values.length);
		System.out.println(Arrays.toString(values));
	}
	
	public static void mergeSort(int[] input, int start, int end) {
		if (end-start<2) {
			return;
		}
		int midpoint = (start+end)/2;
		//recursive call one breaks down the left hand side of the merge split to individual sorted arrays
		mergeSort(input, start, midpoint);
		//recursive call 2 breaks down the right hand side
		mergeSort(input,midpoint,end);
		//final recursive call compares the results of recursive calls one and two and merges them in order
		merge(input, start,midpoint,end);
	}
	public static void merge(int[] input,int start,int mid,int end) {
		//Optimisation 1.  if the lowest value in the right array is greater than the highest value in the left everything is already in order.
		//there is no need to change what is written in the existing array.
		if(input[mid-1]<=input[mid]) {
			return;
			}
		//Otherwise we do need to merge.
		int i=start;
		int j=mid;
		int tempIndex=0;
		int[] holder= new int[end-start];
		while(i<mid&&j<end) {
			//very concise if:then and use of post increment.  Bit confusing but the ++'s only happen after the initial if has been worked out.
			holder[tempIndex++]=input[i]<=input[j]?input[i++]:input[j++];
			System.out.println(Arrays.toString(input));
		}
		System.arraycopy(input, i, input, start+tempIndex, mid-i);
		System.arraycopy(holder, 0, input, start, tempIndex);
	}

}
