package arrays_subarrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class MaximumDifference2Elements {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		/*Given an array arr[] of integers, find out the maximum difference between any two elements 
		 * such that larger element appears after the smaller number.
		 * */ 
		
		/*
		 * naive solution - O(n^2)
		 * efficient solution - O(n)*/
		int min = a[0];
		int max = Integer.MIN_VALUE;
		for(int i = 1; i < a.length; i++) {
			max = Math.max(max, a[i] - min);
			min = Math.min(min, a[i]);
		}
		
		System.out.println("The maximum difference between 2 elements is " + max);
	}

}
