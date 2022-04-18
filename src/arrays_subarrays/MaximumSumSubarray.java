package arrays_subarrays;

import java.io.BufferedReader;
import java.util.Arrays;
import java.io.IOException;
import java.io.InputStreamReader;
public class MaximumSumSubarray {
	// Question - Find the maximum sum of a subarray in given array
	
	static int naiveApproach(int [] a) {	// Time - O(n^2), space - O(1)
		int currentMax = 0;
		int result = Integer.MIN_VALUE;
		for(int i = 0; i<a.length; i++) {
			currentMax = 0;
			for(int j = i; j<a.length; j++) {
				currentMax += a[j];
				result = Math.max(result, currentMax);
			}
			
		}
		return result;
	}
	
	static int efficientApproach(int [] a) {	// Time - O(n), space - O(1)
		int previousMax = a[0];
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i<a.length; i++) {	
			// either we take a[i] itself OR we take the sum of (SumTillPreviousElement + a[i])
			previousMax = Math.max(previousMax + a[i], a[i]);
			max = Math.max(max, previousMax);
		}
		
		return max;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		// naive approach
		
		
		// efficient approach
		System.out.println("The maximum sum of subarray is " + efficientApproach(a));
		
	}

}
