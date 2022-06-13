package recursion;

import java.util.Scanner;

public class NRaiseToPowerP {

	public static int power(int n, int p) {
		if(p == 0) {
			return 1;
		}
		return (n * power(n,p-1));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int p = sc.nextInt();
		sc.close();
		System.out.println(n + " raised to the power " + p + " is " + power(n,p));

	}

}
