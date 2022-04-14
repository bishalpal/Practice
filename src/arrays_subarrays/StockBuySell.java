package arrays_subarrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class StockBuySell {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();		
		//suppose u know the future prices of a stock. Find the maximum profit
		
		int profit = 0;
		for(int i = 1; i<a.length; i++) {
			if(a[i] > a[i-1])
				profit+=(a[i] - a[i-1]);
		}
		System.out.println("Profit = " + profit);
		

	}

}
