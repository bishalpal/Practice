package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class PrintAllSubsequences {
	/*
	 * for every element in the array, we have 2 choices, either take that element or not take.
	 * */
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
