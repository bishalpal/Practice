package recursion;

import java.util.Scanner;

public class Print1toN {
	public static void print(int i, int n) {
		if(i>n)
			return;
		System.out.println(i);
		print(i+1,n);
	}
	
	public static void print2(int n) {
		// printing 1 to n
		if(n == 1) {
			System.out.print(n+" ");
			return;
		}
		
		print2(n-1);
		System.out.print(n+" ");
	}
	
	public static void printNto1(int n) {
		if(n == 1) {
			System.out.print(n+" ");
			return;
		}
		System.out.print(n + " ");
		printNto1(n-1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		print(1,n);
		System.out.println();
		print2(n);
		System.out.println();
		printNto1(n);
	}
	

}
