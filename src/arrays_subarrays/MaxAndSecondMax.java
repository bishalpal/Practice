package arrays_subarrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.ArrayList;

public class MaxAndSecondMax {
    public static ArrayList<Integer> largestAndSecondLargest(int arr[])
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        int max = Integer.MIN_VALUE;
        int secondmax = Integer.MIN_VALUE;
        for(int i = 0; i<arr.length; i++) {
            if(arr[i] > max) {
                secondmax = max;
                max = arr[i];
            }
            else if(arr[i] > secondmax && arr[i]!=max) {
                secondmax = arr[i];
            }
        }
        result.add(max);
        
        if(secondmax == Integer.MIN_VALUE || max == secondmax)
            result.add(-1);
        else
            result.add(secondmax);
        
        return result;
    }
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		ArrayList<Integer> result = largestAndSecondLargest(a);
		System.out.println("The largest and second largest element in the array are : ");
		for(int i = 0; i<result.size(); i++) {
			System.out.print(result.get(i) + " ");
		}
	}

}
