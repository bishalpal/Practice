package arrays_subarrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
public class SubarraySumN {

	static boolean check(int[] a, int k) {
		//naive solution - use 2 loops
		// optimized solution - use prefix sum and hashset, but here we find for (presum - k) in hashset
		
		int presum = 0;
		HashSet<Integer> h = new HashSet<Integer>();
		for(int i = 0; i<a.length; i++) {
			presum+=a[i];
			if(h.contains(presum-k) || presum == k)
				return true;
			h.add(presum);
		}
		
		return false;
	}
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			int [] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			if(check(a,k))
				System.out.println("The given array contains a subarray with given sum "+ k);
			else
				System.out.println("The given array DOES NOT contain a subarray with given sum "+ k);
		}
		
		/*
		 * if(check(a,k))
		 * System.out.println("The given array contains a subarray with given sum "+ k);
		 * else System.out.
		 * println("The given array DOES NOT contain a subarray with given sum "+ k);
		 */
		
	}

}
