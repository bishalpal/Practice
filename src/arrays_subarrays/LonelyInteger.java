package arrays_subarrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LonelyInteger {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split("\\s+");
		br.close();
		int[] a = new int[st.length];
		
		for(int i = 0; i<st.length; i++) {
			a[i] = Integer.parseInt(st[i]);
		}
		
		
		// finding the unique integer in the array using XOR
		int result = a[0];
		for(int i = 1; i<a.length; i++) {
			result = result ^ a[i];
		}
		
		System.out.println("The integer which occurs only once in the array is = " + result);
		
	}

}
