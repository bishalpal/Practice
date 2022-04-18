package arrays_subarrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaximumCircularSubarraySum {
	
	public static int naiveApproach(int [] a) {
		// the idea is to consider every element as the beginning element and calculate the maximum sum of the subarrays starting from this element. We compare the sum of the max sum of subarrays of each element with each other and return the result.
		int result = Integer.MIN_VALUE;
		for(int i = 0; i<a.length; i++) {
			int currentSum = a[i];
			int maxSum = a[i];
			
			for(int j = 1; j<a.length; j++) {
				int index = (i + j) % a.length;
				currentSum += a[index];
				// we check if the sum of the current subarray that begins with i is greater than rest of the  subarrays that begin with i
				maxSum = Math.max(currentSum, maxSum);
			}
			// after we get the maximum of all the circular subarrays beginning from the i'th element, we set the result; i.e. max of the maximum results seen so far.
			result = Math.max(maxSum, result);
		}
		
		return result;
	}
	
	
	public static int kadaneAlgo(int [] a) {
		int currentmax = a[0];
		int max = Integer.MIN_VALUE;
		for(int i = 1; i<a.length; i++) {
			currentmax = Math.max(currentmax + a[i], a[i]);
			max = Math.max(max, currentmax);
		}
		return max;
	}
	
	// kadane algo to find minimum subarray sum
	public static int modifiedKadaneAlgo(int [] a) {
		int currentmin = a[0];
		int min = a[0];
		
		for(int i = 1; i<a.length; i++) {
			currentmin = Math.min(currentmin + a[i], a[i]);
			min = Math.min(min, currentmin);
		}
		
		return min;
	}
	
	public static int efficientApproach(int [] a) {
		int result = Integer.MIN_VALUE;
		int max_normalsubarraysum = kadaneAlgo(a);
		
		if(max_normalsubarraysum < 0)
			return max_normalsubarraysum;
		
		int arr_sum = 0;		// store the sum of the complete array
		for(int i = 0; i<a.length; i++) {
			arr_sum += a[i];
			a[i] = -a[i];
		}
		// we ADD the result of kadaneAlgo instead of subtracting from arr_sum because we are finding maximum sum in inverted array which is actually minimum sum of subarray in original array.
		int max_circularsubarraysum = arr_sum + kadaneAlgo(a);
		result = Math.max(max_normalsubarraysum, max_circularsubarraysum);
		
		return result;
	}
	
	public static int easyEfficientApproach(int [] a) {
		int result = Integer.MIN_VALUE;
		int max_normalsubarraysum = kadaneAlgo(a);
		
		if(max_normalsubarraysum < 0)
			return max_normalsubarraysum;
		
		int arr_sum = 0;		// store the sum of the complete array
		for(int i = 0; i<a.length; i++) {
			arr_sum += a[i];
		}
		// we subtract the minimum_sum of circular subarray from the array sum.
		
		int max_circularsubarraysum = arr_sum - modifiedKadaneAlgo(a);
		result = Math.max(max_normalsubarraysum, max_circularsubarraysum);
		
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		// naive approach
		System.out.println("The maximum circular subarray sum is " + naiveApproach(a));
		
		// efficient approach
		System.out.println("The maximum circular subarray sum is " + efficientApproach(a));
		
		// easy efficient approach  - not working as expected
		System.out.println("The maximum circular subarray sum is " + easyEfficientApproach(a));
		
	}

}
