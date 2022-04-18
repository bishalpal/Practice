package arrays_subarrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaxConsecutive1s {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		int n = a.length;
		int result = 0;
		int currentCount = 0;
		
		for(int i = 0; i<n; i++) {
			if(a[i] == 0) {
				currentCount = 0;
			}
			else {
				currentCount++;
				result = Math.max(currentCount, result);
			}
		}
		
		System.out.print("Maximum number of consecutive 1s in the binary array is " + result);
	}

}
