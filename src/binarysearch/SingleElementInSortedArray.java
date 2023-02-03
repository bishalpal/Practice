package binarysearch;

import java.io.BufferedReader;
import java.util.Arrays;
import java.io.IOException;
import java.io.InputStreamReader;

public class SingleElementInSortedArray {
	
	/*
	 * Problem - You are given a sorted array consisting of integers where every element appears exactly twice 
	 * except for 1 element which appears exactly once. Find this single element which appears only once.
	 * 
	 * 
	 * Naive approach - linearly traverse the array, do XOR operation on all the elements
	 * 					result is the single element.  Time complexity - O(n), Space complexity - O(1)
	 * 					XOR any 2 same number => answer is always 0
	 * 					XOR any number with 0 => answer is always the number.
	 * 		For info -  XOR any even number with 1 => you will get the next number.
	 * 		For info -  XOR any odd number with 1 => you will get the previous number.		
	 * 
	 * 
	 * Efficient approach - since it's a sorted array, we can use binary search to search the number.
	 * now, how to search it =>
	 * we have to find the breakpoint where 
	 * 		to the left of the breakpoint, all the elements appear twice
	 * 		to the right of it, there is the SINGLE ELEMENT and then all the elements which appear twice
	 * 
	 * To find this breakpoint we use this simple observation. for eg - array = [1 1 2 3 3 5 5 6 6]
	 * 	ON LEFT HALF of breakpoint
	 * 	1st instance of element => even index
	 *  2nd instance of element => odd index
	 *  
	 *  ON RIGHT HALF of breakpoint
	 *  1st instance of element => odd index
	 *  2nd instance of element => even index.
	 *  
	 *  Now, we need to find this breakpoint using binary search.
	 *  initially, set low = 0, high = 2nd last element of array. 	This is because we want to take care of an
	 *  															edge case - if the single element is at the end.
	 *  															low will point to the element just after the breakpoint.
	 *  mid = (low + high)/2 
	 *  Let's check for whether 'mid' is in left half of breakpoint or not.
	 *  if mid is even then check => if( a[mid] == a[mid+1] ) 
	 *  								if TRUE =>( then it means we are on the left half of breakpoint.
	 *  							    and inorder to find the breakpoint which is just next to the left half,
	 *  								we do, low = mid + 1 )
	 *  								if FALSE =>( then it means we are on the right half of breakpoint.									
	 *  								inorder to find breakpoint which is just at the beginning of right half,
	 *  								we do high = mid - 1 )
	 *  continue doing this until low >= high
	 *  why so ? it's because  low points to the index which is exactly after the left half i.e. the breakpoint.
	 *  		 and high points to index exactly before the right half. 
	 *  so result is a[low]
	 *  
	 * */	
	public static int naiveApproach(int[] inputArray) {
		int result = inputArray[0];
		for(int i = 1; i < inputArray.length; i++) {
			result ^= inputArray[i];
		}
		return result;
	}
	
	public static int efficientApproach(int[] inputArray) {
		int low = 0;
		int high = inputArray.length - 2;
			
		while(low <= high) {								// we check if we are in left half or not.
			int mid = (low + high) >> 1;
			if(inputArray[mid] == inputArray[mid ^ 1]) 	// this XOR automatically takes care of the even / odd index to check.
				low = mid + 1; 							// i.e I am in left half, I will find the breakpoint just after the left half. so low = mid +1 
			else
				high = mid - 1;		// i.e I am in right half, I will find breakpoint at the beginning of right half. So, shrink it.
		}
		
		return inputArray[low];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int [] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		br.close();
		
		// using naive approach
		System.out.println("The single element is in the array is : " + naiveApproach(arr));
		
		// using efficient approach
		System.out.println("The single element is in the array is : " + efficientApproach(arr));
	}

}
