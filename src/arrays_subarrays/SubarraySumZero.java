package arrays_subarrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.io.IOException;

public class SubarraySumZero {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		//naive solution - O(n^2)     use 2 loops
		
		//optimized solution - use prefix sum and hashing
		HashSet<Integer> h = new HashSet<Integer>();
		int presum = 0;
		for(int i = 0; i<a.length; i++) {
			presum+=a[i];
			if(h.contains(presum)) { 
				System.out.println("There is a subarray with sum 0");
				return;
			}
			if(presum == 0) {
				System.out.println("There is a subarray with sum 0");
			}
			h.add(presum);
		}
		
	}

}
