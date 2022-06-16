package recursion;

public class PrintCountOfSubsequencesSumK {

	/*
	 * We need to print total number of subsequences of the array which have sum = K
	 * 
	 * Time complexity : O(2^n)
	 * we can do slight optimization by adding another base case that
	 * 		if(sum > K)		return 0;
	 * but this will help only if our input array contains only +ve elements.
	 * 
	 * The trick below is used in many DP problems where we need to calculate the count
	 * Trick
	 * 1. make the return type of function = int
	 * 2. in base case
	 * 		if condition satisfied -> return 1;
	 * 		if condition not satisfied -> return 0;
	 * 
	 * 3. store the value of left recursive call in a variable, say L
	 * 4. store the value of right recursive call in a variable, say R
	 * 
	 * 5. return the sum of L+R for the recursive function
	 * NOTE - since we are not printing the subsequence, we won't need the additional DS i.e. the arraylist
	 */
	public static int printCount(int i, int K, int sum, int[] a) {
		// base condition
		if(i == a.length) {
			if(sum == K) {
				return 1;
			}
			return 0;
		}
		
		// pick the current element
		sum += a[i];
		int l = printCount(i+1, K, sum, a);
		
		// not pick the current element
		sum -= a[i];
		int r = printCount(i+1, K, sum, a);
		
		return l+r;
	}
	
	public static void main(String[] args) {
		int [] a = {1,2,1};
		int K = 2;
		
		System.out.print("The number of subsequences which have the sum == " + K + " is ");
		System.out.println(printCount(0,K,0,a));

	}

}
