package arrays_subarrays;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.HashSet;
import java.io.IOException;
import java.io.InputStreamReader;
public class CountDistinctElements {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		HashSet<Integer> set = new HashSet<Integer>();
		for(int i = 0; i<a.length; i++) {
			set.add(a[i]);
			
		}
		int result = set.size();
		System.out.println("The number of distinct elements in array are " + result);
	}

}
