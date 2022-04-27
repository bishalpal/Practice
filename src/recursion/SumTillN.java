package recursion;

import java.util.Scanner;

public class SumTillN {

	public static int sum(int n) {
		if (n == 0)
			return 0;
		return n + sum(n-1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		System.out.println("The sum till " + n + " is equal to " + sum(n));

	}

}
