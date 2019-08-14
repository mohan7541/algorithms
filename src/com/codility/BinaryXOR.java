package com.codility;

/**
 * 
 * @author Mohan
 * Complexity:-
 *		expected worst-case time complexity is O(N);
 *  	expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).
 *
 */
public class BinaryXOR {
	public static void main(String[] args) {
		  int num1 = 42;
		  int num2 = 15;
		  
		  int[] arr = {9, 3, 9, 3, 9, 7, 9};
		  
		  int unpaired = arr[0] ;
		   
		  for(int i = 1; i<arr.length; i++) {
			  unpaired = unpaired ^ arr[i];
			  System.out.println("unpaired at:"+i+":::"+unpaired);
		  }
		  
		  System.out.println(9 ^ 7);
	}
}
