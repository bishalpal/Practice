package arrays_subarrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MoveZeroToEnd {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		br.close();
		/*naive solution - use 2 loops
		 * time - O(n^2)
		 * space - O(1)
		 * */
		/*
		 * Efficient solution - O(n) */
		
		int count = 0;
		for(int i = 0; i < a.length; i++) {
			if(a[i] != 0) {
				int temp = a[count];
				a[count] = a[i];
				a[i] = temp;
				count++;
			} 
		}
		for(int i : a)
			System.out.print(i + " ");
		
	}

}
