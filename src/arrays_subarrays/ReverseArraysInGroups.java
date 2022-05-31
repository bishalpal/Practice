package arrays_subarrays;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ReverseArraysInGroups {

	public static void reverse(int[] a, int n, int k) {
		if(k == 1)
			return;
		
		for(int i = 0; i<n; i+=k) {
			int left = i;
			int right = Math.min(i + k -1, n-1);		// this will handle all the cases i.e 
														// in case (k < n) OR (k > n)
			
			int temp = 0;
			while(left < right) {
				temp = a[left];
				a[left] = a[right];
				a[right] = temp;
				left++;
				right--;
			}
		}
	}
	
	
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] input = br.readLine().split(" ");
		int k = Integer.parseInt(br.readLine());
		br.close();
		
		int[] a = new int[input.length];
		for(int i = 0; i<a.length; i++) {
			a[i] = Integer.parseInt(input[i]);
		}
		
		reverse(a, a.length, k);
		
		System.out.print(Arrays.toString(a));

	}

}
