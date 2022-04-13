package arrays_subarrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;
import java.util.HashMap;

// similar to longestsubarraysumN
public class LongestSubarrayEqualZerosOnes {

	static int length(int[] arr) {
		int presum = 0;
	       HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	       int max = 0;
	       for(int i = 0; i < arr.length; i++) {
	           presum += arr[i] == 0 ? -1 : 1;
	           
	           if(presum == 0) {
	               max = i+1;
	           }
	           if(map.containsKey(presum)) {
	               max = Math.max(max, i - map.get(presum));
	           }
	           else {
	               map.put(presum, i);
	           }
	       }
	       return max;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		System.out.println("The length of longest subarray containing equal number of 0's and 1's is " + length(a));
		
	}

}
