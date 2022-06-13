package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class PrintAllSubsequences {
	/*
	 for every element in the array, we have 2 choices, either take that element or not take.
	 in function arguments, i = index. I need to traverse the array upto a.length-1
	 arraylist b is the list where we store the subsequences.
	
	 	Time complexity : O(2^n * n) ... for every element we have 2 choice -> take / not take
									... for every subsequence we create, we need to print it, 
										so if we use a loop to do it then --- O(n) time
									
	 	Space complexity: O(n)		... because, the depth of the recursion tree at max is 3 in case
	  									we provide 3 elements in array a. At max only 3 recursion calls
	  									always stay in the stack space.  (CHECK IT OUT USING RECURSION TREE)
	  
	 */
	public static void printSubsequence(int i, int[] a, ArrayList<Integer> b) {
		if(i == a.length) {
			System.out.println(b.toString());
			return;
		}
		// take element
		b.add(a[i]);
		printSubsequence(i+1, a, b);
		
		// not take element
		b.remove(new Integer(a[i]));
		printSubsequence(i+1, a, b);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int [] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		br.close();
		ArrayList<Integer> b = new ArrayList<Integer>(a.length);
		printSubsequence(0, a, b);

	}

}
