package recursion;

import java.util.ArrayList;

public class PrintSubsequencesSumK {

	/*
	 * U need to print all the subsequences of array whose sum is equal to K
	 * 
	 * this question is similar to PrintAllSubsequences
	 * instead of printing all the subsequences, we print only those whose sum == K
	 * */
	
	public static void printSubsequence(int i, int sum, int K, int[] a, ArrayList<Integer> b) {
		if(i == a.length) {
			if(sum == K) {
				System.out.println(b.toString());
			}
			return;
		}
		
		// take the element
		b.add(a[i]);
		sum += a[i];
		printSubsequence(i+1, sum, K, a, b);
		
		// not take the element
		sum -= a[i];
		b.remove(new Integer(a[i]));
		printSubsequence(i+1, sum, K, a, b);
	}
	public static void main(String[] args) {
		int [] a = {1,2,1};
		int K = 2;
		ArrayList<Integer> b = new ArrayList<>();
		System.out.println("The subsequences whose sum is 2 are : ");
		printSubsequence(0,0,K,a,b);

	}

}
