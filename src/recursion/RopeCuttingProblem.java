package recursion;

import java.util.Scanner;

public class RopeCuttingProblem {
	
	// T.C = O(3^n)		how - suppose the value of either a, b or c is 1 [worst case], then at each level there 
	// will be 3^(level) pieces being cut and this will keep on continuing 'n' times since at each level,
	// only a piece of length 1 is being cut.
	
	public static int func(int n, int a, int b, int c) {
		if(n == 0)
			return 0;
		if(n < 0)
			return -1;
		
		int result = Math.max(func(n-a, a, b, c), Math.max(func(n-b, a, b,c), func(n-c, a, b, c)));
		
		if(result == -1)
			return -1;
		return result + 1;
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		sc.close();
		
		System.out.println("The maximum number of pieces of the rope that can be cut are = " + func(n,a,b,c));
		
	}

}
