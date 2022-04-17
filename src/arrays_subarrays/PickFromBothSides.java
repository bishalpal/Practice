package arrays_subarrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

import java.util.ArrayList;
/* Question link - https://www.interviewbit.com/problems/pick-from-both-sides/
 * Given an integer array A of size N.
You have to pick exactly B elements from either left or right end of the array A to get maximum sum.
Find and return this maximum possible sum.
NOTE: Suppose B = 4 and array A contains 10 elements then

You can pick first four elements or can pick last four elements or can pick 1 from front and 3 from back etc . 
you need to return the maximum possible sum of elements you can pick.
 * */
public class PickFromBothSides {
	public static int maximum(int[] A, int B) {
		int max;
        int currentsum = 0;

        for(int i = 0; i<B; i++) {
            currentsum+=A[i];
        }
        max = currentsum;

        int include = A.length - 1;
        int exclude = B-1;

        while(include >= 0 && exclude >=0) {
            currentsum += A[include] - A[exclude];
            max =  Math.max(currentsum,max);
            include--;
            exclude--;
        }
        return max; 
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int B = Integer.parseInt(br.readLine());
		
		System.out.println(maximum(a,B));
		

	}

}
