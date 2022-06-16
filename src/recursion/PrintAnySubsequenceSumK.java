package recursion;

import java.util.ArrayList;

public class PrintAnySubsequenceSumK {

	/*
	 * Print any 1 subsequence whose sum is K
	 * 
	 * this is different from PrintSubsequencesSumK where we needed to print ALL POSSIBLE subsequences
	 * whose sum is K
	 * 
	 * Aim is to avoid future recursion calls. To do this, we have 2 ways
	 * This idea is not advisable
	 * M-I : use a static boolean variable flag which is initially set to false. 
	 * 		 in the base case condition we can just check if(i == a.length && flag == false)
	 * 		 for the first time when a subsequence is found, we pass the base case test and set the flag = true;
	 * 
	 * This idea is preferred - 		
	 * M-II : if the recursion call itself tells us whether we found an answer once or not, we can avoid
	 *        future recursion calls. So make the return type of the recursive function as boolean
	 *        after every recursion call, check if it returns true or not. If true is returned, then no need to 
	 *        do further recursion calls !
	 */
	
	public static boolean printSubsequenceSumK(int i, int K, int sum, int[] a, ArrayList<Integer> b) {
		// base case
		if(i == a.length) {							
			if(sum == K) {							
				System.out.println(b.toString());
				return true;
			}
			else					// if index has reached a.length but sum != K, then return false
				return false;
		}
		
		// pick the current element
		b.add(a[i]);
		sum += a[i];
		if (printSubsequenceSumK(i+1, K, sum, a, b) == true) 
			return true;
		
		// not pick an element
		sum -= a[i];
		b.remove(new Integer(a[i]));
		if(printSubsequenceSumK(i+1, K, sum, a, b) == true)
			return true;
		
		// if both - pick and not pick recursion calls did not find a subsequence, return false;
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a = {1,2,1};
		int K = 2;
		ArrayList<Integer> b = new ArrayList<>();
		System.out.println("The subsequences whose sum is 2 are : ");
		printSubsequenceSumK(0,K,0,a,b);
	}

}
