package arrays_subarrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class StrongestNeighbour {

	/*
	 * Given an array arr[] of n positive integers. 
	 * The task is to find the maximum for every adjacent pairs in the array.
	 */
    static void maximumAdjacent(int arr[]){
         /* Function should print max adjacents for all pairs */

         for(int i = 1; i<arr.length; i++) {    
             System.out.print(Math.max(arr[i-1],arr[i]) + " ");
         }
        
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		maximumAdjacent(a);

	}

}
