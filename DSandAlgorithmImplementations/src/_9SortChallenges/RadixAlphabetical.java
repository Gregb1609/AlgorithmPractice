package _9SortChallenges;

import java.util.Arrays;

public class RadixAlphabetical {
	public static void main(String[] args) {
		String [] values = {"pizza","again","shirt","light","brown"};
		System.out.println(Arrays.toString(values));
		radixSort(values,5);
		System.out.println(Arrays.toString(values));
	}

	/* THis meth0d was written to sort a fixed length array of lowercase 
	 * chars using a radix sort.  When I started I was unaware that chars
	 * also have a numeric value.  a simplified solution is added below
	 * but this is the one I worked out on my own.
	 * */
	public static String[] radixSort(String[] input,int width) {
			char[] alphaWeight = new char[26];//this array give each character numeric weighting
			int alphaNum=0;
			for(char let='a';let<='z';let++) {//this loop populates with each character
				alphaWeight[alphaNum]=let;
				alphaNum++;
			}
			System.out.println(Arrays.toString(alphaWeight));
			
			for(int i = width-1;i>=0;i--) {//main loop iterates through each character in each string and runs sort
				radixSingleSort(input,alphaWeight,i,26);
			}
		
		return input;
	}
	
	public static void radixSingleSort(String[] input,char[] weight,int position, int radix) {
		
		int numOfVals= input.length;
		int[] counter= new int[radix];;//radix used as is number of different possibilities for value
		
		for (String value: input) {//this loop increments the tallys in the indexes that relate to chars
			//in the input
			
			counter[getIndex(weight,value, position)]++;//see method description below
		}
		for (int j=1;j<counter.length;j++) {//this loop adjusts the count to a running sum of how many
			//values are less than or equal to this point in the array. it makes the sort stable.
			counter[j]+=counter[j-1];
		}
		System.out.println(Arrays.toString(counter));
		String[] temp = new String[numOfVals];
		int tempIndex = numOfVals-1;
		String[] selection=input.clone();//creates a NON-DEPENDENT copy of the input array we can mess with for this iteration
		System.out.println(Arrays.toString(selection)+"Position"+position);
		for(int pointer=counter.length-1;pointer>=1;pointer--) {//loop iterates through the count of each value
			if((tempIndex+1)-counter[pointer-1]>=0) {//if the next iteration has a value less than the tempIndex
				//we transfer the related string in to the temp array and decrease the tempIndex until it matches
				//the value at pointer -1
				while((tempIndex+1)-counter[pointer-1]>0) {
				temp[tempIndex]=getString(selection,weight[pointer],position);
				tempIndex--;
				}
			}
			if(pointer==1) {//last iteration gremlin... Unsure how to avoid, could probably factor in to first 'if' but it isnt
				//too messy...
				while(tempIndex>=0) {
					temp[tempIndex]=getString(selection,weight[pointer-1],position);
					tempIndex--;
					}
			}
		}
		System.out.println(Arrays.toString(temp)+"Transferring");
		for(int i =0;i<input.length;i++) {//writes back to main array
			input[i]=temp[i];
		}
		
		
	}
	public static int getIndex(char[] weight, String input, int position) {//method that gets
		//int weighting of a char by iterating through an array of chrs and returning the index 
		//where the value is found
		char character=input.charAt(position);
		for(int i = 0;i<weight.length;i++) {
			if(weight[i]==(character)){
				return i;
			}
		}
		return -1;
	}
	public static String getString(String[] selection, char let, int position) {//method that gets
		//the parent string of chars we ordered.  It also removes the string from the selection 
		//array for the rest of the iteration to prevent the same string selecting twice.
		for(int i=selection.length-1;i>=0;i--) {
			if(selection[i].charAt(position)==let) {
				String retVal=selection[i];
				selection[i]="     ";
				return retVal;
			}
		}
		return "nope";
	}
}
