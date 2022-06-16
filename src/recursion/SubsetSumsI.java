package recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.io.IOException;
import java.util.ArrayList;

public class SubsetSumsI {

	/*
	 * Optimized solution
	 * 
	 * Time complexity : O(2^n + 2^n*log(2^n))   ~ O(2^n)
	 * 					here 2^n is because for every element we have 2 choices -> pick/not-pick
	 * 					for sorting an array, we need nlogn time. Now here, n (i.e. size of the array) 
	 * 					is 2^n i.e. the size of the array containing the sums of subarrays.
	 * 					
	 * Space complexity : O(2^n)
	 * 
	 * Method - think of a recursive way which can decide to select or not-select a particular element
	 * 			for a subarray. Do this for all the elements.
	 * 
	 */
	public static void subsetSums(int i, int sum, int[] a, ArrayList<Integer> result) {
		if(i == a.length) {
			result.add(sum);
			return;
		}
		
		// pick the element					so increase the sum by a[i]
		subsetSums(i+1, sum+a[i], a, result);
		
		// not pick the element				since we don't pick the element, we don't increase the sum.
		subsetSums(i+1, sum, a, result);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int [] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		br.close();
		
		ArrayList<Integer> result = new ArrayList<>();
		subsetSums(0, 0, a, result);
		Collections.sort(result);
		System.out.println(result.toString());
	}

}
