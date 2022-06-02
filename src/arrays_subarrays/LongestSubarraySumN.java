package arrays_subarrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class LongestSubarraySumN {

	static int longestSubarray(int[] a, int k) {
		// naive approach = O(n^2)
		// efficient approach - use prefix sum and Hashmap O(n) - time, O(n) - space
		/* even more efficient approach - sliding window using 2 pointers (this approach
		   doesn't work with -ve numbers */

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		int presum = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < a.length; i++) {
			presum += a[i];

			if (presum == k)
				max = i + 1;
			if (!map.containsKey(presum))
				map.put(presum, i);
			if (map.containsKey(presum - k))
				max = Math.max(max, i - map.get(presum - k));
		}

		return max;
	}
	
	static int optimisedApproach(int []a, int k) {
		int max = Integer.MIN_VALUE;
		int n = a.length;
		int i = 0;		// left pointer
		int j = 0;		// right pointer
		int sum = 0;	// sum of the elements b/w left and right pointer
		
		while(j<n) {
			sum += a[j];
			if(sum < k) {						// case 1 : sum of elements b/w i and j is less than k
				j++;
			}
			else if(sum == k) {					// case 2 : sum of elements b/w i and j is equal to k
				max = Math.max(max, j-i+1);		
				j++;							// proceed further in the array to check for even longer
												// subarray with sum k
			}
			
			else if(sum > k) {					// case 3 : sum of elements b/w i and j is greater than k
				while(sum > k) {				// we need to increment i until the sum becomes less than k
					sum -= a[i];
					i++;
				}
				if(sum == k) {					// after control exits the while loop, check if sum == k
					max = Math.max(max, j-i+1);
				}
				j++;							// we need to increment j so that we are able to cover the 
												// next element of the array.
			}
			
		}
		
		return max;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());

		int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int result = longestSubarray(a, k);
		System.out.println("The length of longest subarray having sum " + k + " is " + result);
		System.out.println("Using optimised approach, the length of longest subarray having sum " + k + " is " + optimisedApproach(a,k));
	}

}
