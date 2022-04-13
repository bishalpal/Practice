package arrays_subarrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public class FrequencyDistinctElements {

	public static void main(String[] args) throws IOException {
		// Time complexity : Theta(n)
		// Space complexity : O(n)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for(int i = 0; i < a.length; i++) {
			hm.put(a[i], hm.getOrDefault(a[i], 0)+1 );
		}
		
		for(Map.Entry<Integer, Integer> m : hm.entrySet()) {
			System.out.println(m.getKey() + " : " + m.getValue());
		}
	}

}
