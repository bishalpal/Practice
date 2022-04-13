package arrays_subarrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LeftRotateDPlaces {
	static void reverse(int[] a, int start, int end) {
		while(start<=end) {
			int temp = a[end];
			a[end] = a[start];
			a[start] = temp;
			start++;
			end--;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();		

		/* naive solution : left rotate by 1 k times
		 * time complexity : O(kn)
		 * space complexity : O(1)
		 * */
		
		/*efficient solution : 
		 * time : Theta(n)
		 * space : Theta(k)
		 * */
		
		/*most efficient solution : 
		 * First reverse 0 to k-1 elements.
		 * Second reverse k to n-1 elements.
		 * Third reverse the entire array i.e 0 to n-1
		 * time complexity : O(n)
		 * space complexity : O(1)
		 * */
		
		// most efficient
		reverse(a, 0, k-1);
		reverse(a, k, a.length-1);
		reverse(a, 0, a.length-1);
		
		for(int i : a)
			System.out.print(i+" ");
	}

}
