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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());

		int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int result = longestSubarray(a, k);
		System.out.println("The length of longest subarray having sum " + k + " is " + result);
	}

}
