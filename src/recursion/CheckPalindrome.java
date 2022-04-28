package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckPalindrome {
	public static boolean check(char [] a, int f, int l) {
		if(f >= l)
			return true;
		
		if(a[f] != a[l])
			return false;
		else
			return check(a,f+1, l-1);
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st = br.readLine();
		char [] c = st.toCharArray();
		
		
		
		if(check(c, 0, c.length-1))
			System.out.println("The enterd string is a palindrome");
		else
			System.out.println("The enterd string is not a palindrome");
	}

}
