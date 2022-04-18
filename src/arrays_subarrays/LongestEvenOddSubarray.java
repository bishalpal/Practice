package arrays_subarrays;

import java.io.BufferedReader;
import java.util.Arrays;
import java.io.IOException;
import java.io.InputStreamReader;

// Find the length of the longest even-odd subarray
public class LongestEvenOddSubarray {

	public static int naiveApproach(int [] a) { // Time -  O(n^2), space - O(1)
		int res = 1;
		int currentlength = 1;
		// here we find the subarrays STARTING from the current element i.e "i"
		for(int i = 0; i<a.length; i++) {
			currentlength = 1;
			
			for(int j = i+1; j<a.length; j++) {
				
				if((a[j] % 2 == 0 && a[j-1] % 2 != 0) || (a[j] % 2 != 0 && a[j-1] % 2 == 0)) {
					currentlength++;
				}
				
				else	// since the even-odd sequence doesn't continue, then there is no point in using "continue". We have to break the loop and then check if the currentlength is greater than "res" or not
					break;
			}
			res = Math.max(currentlength, res);
		}
		
		return res;
	}
	public static int efficientApproach(int[] a) {	// Time -  O(n), space - O(1)
		// every element has 2 possibilities - either begin a new subarray OR extend it with the previous subarray. We extend the previous subarray if current element is alternating else we begin a new subarray.
		// here we find the subarrays ENDING with the current element.
		
		int res = 1;
		int currentlength = 1;
		
		for(int i = 1; i<a.length; i++) {
			// check if current element is even and prev is odd OR current element is odd and prev is even.
			if((a[i] % 2 == 0 && a[i-1] % 2 != 0) || (a[i] % 2 != 0 && a[i-1] % 2 == 0)) {
				currentlength++;
				res = Math.max(currentlength, res);
			}
			else	// since even-odd sequence broke, then we have to start a new subarray which has the length = 1; afterall every element is a subarray 
				currentlength = 1;
		}
		return res;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		//naive solution
		
		// efficient solution
		System.out.println("The longest even-odd subarray is of length : " + efficientApproach(a));
	}

}
