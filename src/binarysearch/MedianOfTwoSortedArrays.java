package binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

public class MedianOfTwoSortedArrays {
	public static int naiveApproach(int[] a, int[] b) {
		
		return 0;
	}
	
	public static int efficientApproach(int[] a, int[] b) {
		
		return 0;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// take input of arrays from user.
		System.out.println("Enter first sorted array elements  : ");
		int [] arr1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();	
		System.out.println("Enter second sorted array elements  : ");
		int [] arr2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		br.close();
		
		// naive approach
		System.out.println("Median of the 2 sorted arrays is " + naiveApproach(arr1, arr2));
		
		// efficient approach
		System.out.println("Median of the 2 sorted arrays is " + efficientApproach(arr1, arr2));

	}

}
