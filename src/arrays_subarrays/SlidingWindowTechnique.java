package arrays_subarrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 *  Problem - given an array of integers and a number k, find the maximum sum of k consecutive elements.
 *  
 *  this problem can also be of the form - 
 *  If you are given an array and an integer k, you need to find if there is a subarray of
 *  size k with given sum.
 *  For this, we need to just put an if condition checking the maxSum with given sum (in efficient approach) 
 *  
 * */

//Problem statement - If you are given an array and an integer k, you need to find if there is a subarray of
//	size k with given sum.


public class SlidingWindowTechnique {
	
	// naive approach - consider every element as the beginning element and then calculate the sum
	// Time complexity - O((n-k)-k)	... kind of quadratic solution.
	public static int naiveApproach(int [] a, int k) {
		int result = Integer.MIN_VALUE;
		int n = a.length;
		for(int i = 0; i<= n-k; i++) {
			int sum = a[i];
			for(int j = 1; j<k; j++) {
				sum += a[i+j];
			}
			result =  Math.max(sum, result);
		}
		return result;
	}
	
	public static int efficientApproach(int []a, int k) {
		int maxSum = 0;
		int currentSum = 0;
		int n = a.length;
		
		// first calculate the sum of first k elements of array
		for(int i= 0; i<k; i++) {
			currentSum += a[i];
		}
		maxSum = currentSum;
		
		// now we calculate the next set of k element's sum and compare with maxSum.
		// the calculation is done by adding the new element to our currentSum and 
		// removing the (i-k)th element from our currentSum
		for(int i = k; i<n; i++) {
			currentSum += a[i] - a[i-k];
			maxSum = Math.max(currentSum, maxSum);
		}
		
		return maxSum;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();		// TODO Auto-generated method stub
		
		System.out.println("the maximum sum of consecutive k elements is " + naiveApproach(a, k));
		
		System.out.println("the maximum sum of consecutive k elements is " + efficientApproach(a, k));
	}

}
