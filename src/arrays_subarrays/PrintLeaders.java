package arrays_subarrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class PrintLeaders {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		
		
		ArrayList<Integer> temp = new ArrayList<Integer>();
		int leader = a[a.length-1];
		temp.add(leader);
		for(int i = a.length-2; i>=0; i--) {
			if(a[i] > leader) {
				leader = a[i];
				temp.add(leader);
			}
			
		}
		for(int i = temp.size()-1; i>=0; i-- ) {
			System.out.print(temp.get(i)+" ");
		}
	}

}
