package recursion;

import java.util.Scanner;

public class Print1toN {
	public static void print(int i, int n) {
		if(i>n)
			return;
		System.out.println(i);
		print(i+1,n);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		print(1,n);
	}
	

}
