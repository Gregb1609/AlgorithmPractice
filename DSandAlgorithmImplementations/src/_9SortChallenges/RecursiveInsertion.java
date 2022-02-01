package _9SortChallenges;

import java.util.Arrays;

public class RecursiveInsertion {

	public static void main(String[] args) {
		int [] values = {20,35,-15,7,55,1,-22};
		System.out.println(Arrays.toString(values));
		recursiveSort(values);
		System.out.println(Arrays.toString(values));
	}
	//The insertion sort work on the principal of extending a sorted subarray with logic.  it starts by 
	//comparing index 1 with index 0. If 1>0 no change is made but if not index 0 is moved one index to the right.
	//since the value being compared has reached the end of the register the comparing value is dropped here 
	//and the size of the sorted sub-array is increased by 1. next index 2 is selected and moved left until 
	//it reaches a comparison where it is greater than the value OR it hits the zero position and is inserted.
	//Insertion is On(squared) time complexity due to nested loops but is in place and stable.
	
//	  public static int[] sort(int[] input) { 
//		  for(int ordered=1;ordered<input.length;ordered++){//outer loop selects length of sorted sub-array 
//			  	int temp=input[ordered];//selects the value for comparison 
//			  	for(int pointer = ordered;pointer>0;pointer--) {//inner loop iterates through sorted sub array 
//			  		System.out.println(Arrays.toString(input));
//			  		if(input[pointer]>=input[pointer-1]) { 
//			  			break;//if it finds a value greater than the comparison value it skips on
//			  		}else {
//			  			input[pointer]=input[pointer-1];//else it drops the input in place
//			  			input[pointer-1]=temp;
//			  		}
//			  	}
//			  	return input;
//		  }
//	  }
	public static void recursiveSort(int[] input) {
		recursiveHelper(input,input.length);
	}
	
	/*My effort at a purely recursive helper.  It needs an inner and outer loop counter passed to it in the 
	 * method call and so is more difficult to read.  There is a simpler version documented further down the page.
	 */
//	public static int[] recursiveHelper(int[] input, int inOrder, int pointer) {
//		System.out.println(Arrays.toString(input));
//		if(pointer==input.length) {//base case.  The pointer has passed the accessible
//			//indices in the array
//			return input;
//		}
//		int temp=input[pointer];
//		if(pointer==1&&temp<=input[pointer-1]) {// when end of the array is reached and the value needs swapping
//			input[pointer]=input[pointer-1];
//			input[pointer-1]=temp;
//			return recursiveHelper(input,++inOrder,inOrder+1);
//		}
//		if(pointer>1&&temp<=input[pointer-1]) {// when the value needs swapping but not at the end of the array
//			input[pointer]=input[pointer-1];
//			input[pointer-1]=temp;
//			return recursiveHelper(input,inOrder,pointer--);
//		}
//		if(pointer>1){//when the value doesn't need swapping
//			return recursiveHelper(input,inOrder,--pointer);
//		}
//		if(pointer==1) {
//			recursiveHelper(input,++inOrder,inOrder+1);
//		}
//	return input;
//	}
	/*below is the the combination of recursion and iterative.  it is the least lines
	 * of code and quite clean to read.  I must remember in this type of recursion 
	 * its ok for the looping/unboxing to go BEFORE the work the method must do...
	 */
	public static int[] recursiveHelper(int[] input, int sorted){
		if(sorted<2) {
			return input;
		}
		
		recursiveHelper(input,sorted-1);
		
		int temp=input[sorted-1];
		int pointer;
		
		for(pointer=sorted-1;pointer>0&&input[pointer-1]>temp;pointer--) {
			input[pointer]=input[pointer-1];
			System.out.println(Arrays.toString(input));
		}
		input[pointer]=temp;
		return input;
		
		
	}
}
