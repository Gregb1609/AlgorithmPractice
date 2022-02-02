package _8RadixSort;

import java.util.Arrays;

public class RadixSort {

	public static void main(String[] args) {
		int [] values = {4725,4586,1330,8792,1594,5729};
		System.out.println(Arrays.toString(values));
		radixSort(values,10,4);
		System.out.println(Arrays.toString(values));
	}
	//The radix sort works by making assumptions about the data again.  It assumes that the 
	//digits/characters of all inputs can be compared to a weighting scale which has a 
	//fixed range. it also assumes all inputs have the same width(or number of chars /digits.
	//Examples of a radix(which is a number) are bases in counting systems 
	//or 26 in the case of the alphabet.  Obviously 'a' has the highest weighting in 
	//the alphabet and z the lowest.  In base 10 counting 9 would be highest and 0 lowest.
	//This algorithm also sits on top of a more simple sorting algorithm which does some
	//of the work.  It is critical that the algorithm it is paired with is stable of this
	//will not work.  Depending on the base sort the time complexity varies but can be as
	//good as o(n). Is stable and can be in place again depending on the base sort algorithm,
	//this version is not in place as I'm using a counting sort optimised for stable sorting.
	
	public static int[] radixSort(int[] input,int radix, int width) {
			for(int i = 0;i<width;i++) {//main loop iterates through each digit in width and runs sort
				radixSingleSort(input, i, radix);
			}
		
		return input;
	}
	
	public static void radixSingleSort(int[] input,int position, int radix) {
		
		int numOfVals= input.length;
		int[] counter = new int[radix];//radix used as is number of different possibilities for value
		
		for (int value: input) {//this loop increments the tallys in the indexes that relate to digits 
			//in the input.
			counter[getDigit(value,position,radix)]++;
		}
		for (int j=1;j<counter.length;j++) {//this loop adjusts for the stable and changes the count in
			//to a running sum of how many values are less than or equal to this point in the array.
			counter[j]+=counter[j-1];
		}
		int[] temp = new int[numOfVals];
		for(int tempIndex = numOfVals-1;tempIndex>=0;tempIndex--) {//this is confusing but the pre-decrement
			//means that one is taken from the count tally at the position of the digit value. The remainder
			//is subtracted from the insert position index to preserve the stability of the algroithm.
			temp[--counter[getDigit(input[tempIndex],position,10)]]= input[tempIndex];
			System.out.println(Arrays.toString(temp));
			System.out.println("tempIndex"+tempIndex+" Counter"+);
		}
		for(int i =0;i<input.length;i++) {//writes back to main array
			input[i]=temp[i];
		}
	}
	
	public static int getDigit(int input,int position,int radix) {//uses math to get the significant figure at 
		//a position in width.
		return input/(int)Math.pow(radix, position) % radix;
	}

}
