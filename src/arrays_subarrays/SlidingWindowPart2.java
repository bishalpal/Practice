package arrays_subarrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// Problem statement - If you are given an unsorted array of NON NEGATIVE integers and a value, 
// you need to find if there is a subarray with given sum
public class SlidingWindowPart2 {
	
	// for this, we maintain a window of current sum of elements. we keep adding elements until 
	// the current sum is greater than given sum. If our sum is greater than given sum,
	// then we start removing elements from the beginning of the array until it becomes less than given sum
	// if it becomes less, then we again add more elements to our window. If we reach the end and don't get 
	// the required sum, we return false. 
	
	public static boolean efficientApproach(int [] a, int k) {
		
		
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();		// TODO Auto-generated method stub
		
		//System.out.println("the maximum sum of consecutive k elements is " + naiveApproach(a, k));
		
		System.out.println("the maximum sum of consecutive k elements is " + efficientApproach(a, k));

	}

}
