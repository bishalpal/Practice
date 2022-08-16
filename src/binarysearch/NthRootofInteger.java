package binarysearch;

import java.util.Scanner;

/*
 * Nth Root of a Number Using Binary Search
 * 
 * Binary search is not limited to searching an element in an array
 * It can be used in any search space which is monotonically increasing / decreasing in nature.
 * 
 * To do this, 
 * Step 1 - Identify if the function is linearly increasing / decreasing
 * Step 2 - find the search space.
 */
public class NthRootofInteger {

	public static double multiply(double number, int times) {
		double answer = 1.0;
		for(int i = 0; i<times; i++)
			answer = answer * number;
		return answer;
	}
	
	
	public static double getNthRoot(int n, int m) {
		double low = 1;
		double high = m;
		double diff = 1e-6;
		
		while((high - low) > diff) {		// normally, here we would have written while(low > high)
			double mid = (high + low)/2.0;	// but here we are trimming the search space down to the 6th digit.
			if(multiply(mid, n) < m)
				low = mid;
			else
				high = mid;
		}

		System.out.println();
		return high;				// we can also return the high value.
	}
	
	
	public static void main(String[] args) {
		// need to find n'th root of number m
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.close();
		
		double result = getNthRoot(n,m);
		System.out.print("The " + n + "'th root of number " + m + " is ");
		System.out.printf("%.5f", result);
	}

}
