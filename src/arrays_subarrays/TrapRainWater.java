package arrays_subarrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TrapRainWater {
	static int naive_solution(int [] a) {		// Time - O(n^2), Space - O(1)
		int water_stored = 0;
		int n = a.length;
		for(int i = 1; i<n-1; i++) {
			int lmax = a[i];
			int rmax = a[i];
			
			for(int j = 0; j<i; j++) {
				lmax = Math.max(a[j], lmax);
			}
			
			for(int j = i+1; j<n; j++) {
				rmax = Math.max(a[j], rmax);
			}
			
			water_stored += Math.min(lmax, rmax) - a[i];
		}

		return water_stored;
	}
	
	
	static int efficient_solution(int[] a) {	// Time - O(n), Space - Theta(n)
		int water_stored = 0;
		int n = a.length;
		int[] leftmax = new int[n];
		int[] rightmax = new int[n];
		
		int max = a[0];
		// fill the left maximum element for each element in leftmax array
		leftmax[0] = a[0];		// since first element has no other element to it's left.
		for(int i = 1; i<n; i++) {
			leftmax[i] = Math.max(leftmax[i-1], a[i]);
		}
		
		max = a[n-1];		
		// fill the left maximum element for each element in rightmax array
		rightmax[n-1] = a[n-1];		// since last element has no other element to it's right.
		for(int i = n-2; i>=0; i--) {
			rightmax[i] = Math.max(rightmax[i+1], a[i]);
		}
		
		// since first and last element can't store any water, so ignore them
		for(int i = 1; i<n-1; i++) {
			water_stored += Math.min(leftmax[i], rightmax[i]) - a[i];
		}
	
		return water_stored;			
	}
	
	static int more_efficient_solution(int[] a) {	// Time - O(n), Space - O(1)
		// incomplete solution
		int water_stored = 0;
		return water_stored;		
		
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		// naive solution
		System.out.println("The water that can be stored = " + naive_solution(a));
		
		// efficient solution
		System.out.println("The water that can be stored = " + efficient_solution(a));
		
		// more efficient solution  - need to study

	}

}
