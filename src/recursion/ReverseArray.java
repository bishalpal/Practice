package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class ReverseArray {
	public static void reverse(int[] a, int f, int l) {
		if(f>=l) {
			return;
		}
		
		int temp = a[f];
		a[f] = a[l];
		a[l] = temp;
		
		reverse(a, f+1, l-1);
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split("\\s+");
		br.close();
		int[] a = new int[st.length];
		
		for(int i = 0; i<st.length; i++) {
			a[i] = Integer.parseInt(st[i]);
		}
		
		reverse(a, 0, a.length-1);
		System.out.print("Reversed array : " + Arrays.toString(a));
		
	}

}
