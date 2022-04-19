package arrays_subarrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * Problem statement -  find minimum number of group flips required to make all elements same in binary array
 * 
 * naive solution - Traverse the array and count the number of groups of 0s and 1s and then compare them
 * 					we need to flip the group with minimum count
 * 					Traverse the array again and print the index (start and end) of the groups to flip
 * 
 * efficient solution - We can print our result in only 1 traversal
 * 					Trick 1 - the difference b/w the number of groups of 0s and 1s can be either 0 or 1.
 * 					Trick 2 - the array which has different number of groups of 0s and 1s always have the same starting and ending element same while the array which has same no. of groups of 0s and 1s have different elements at start and end.
 * 	
 */
public class MinimumGroupFlips {

	public static void printgroupindex(int checkelement, int[] a, int n) {
		boolean flag = true;
		for(int i = 0; i<n; i++) {
			if(a[i] == checkelement) {
				if(flag == true) {
					System.out.print("From " + i);
					flag = false;
				}		
			}
			else {
				if(flag == false) 
					System.out.println(" till " + (i-1));
				flag = true;
			}
		}
	}
	
	public static void efficientsolutionGFG(int [] a) {
		for(int i = 1; i<a.length; i++) {
			if(a[i] != a[i-1]) {
				if(a[i] != a[0])
					System.out.print("From "+ i);
				else
					System.out.println(" to " + (i-1));
			}			
		}
		if(a[a.length-1] != a[0])
			System.out.println(" to " + (a.length-1));
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		// my solution
		int n = a.length;
		if (a[0] == a[n-1]) {
			int checkelement = a[0] == 1? 0:1;
			printgroupindex(checkelement, a, a.length);
		}
		else {
			int checkelement = 0;
			printgroupindex(checkelement, a, a.length);
			System.out.println(" to " + (a.length-1));;
		}
		
		System.out.println();
		
		
		// efficient solution (from GFG)
		System.out.println("The groups to be inverted are as follows : ");
		efficientsolutionGFG(a);

	}

}
