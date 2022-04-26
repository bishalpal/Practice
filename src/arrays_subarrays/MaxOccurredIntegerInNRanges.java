package arrays_subarrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * Given n integer ranges, the task is to find the maximum occurring integer in these ranges. 
 * If more than one such integer exits, find the smallest one. 
 * The ranges are given as two arrays L[] and R[].  L[i] consists of starting point of range and 
 * R[i] consists of corresponding end point of the range.

For example consider the following ranges.
L[] = {2, 1, 3}, R[] = {5, 3, 9)
Ranges represented by above arrays are.
[2, 5] = {2, 3, 4, 5}
[1, 3] = {1, 2, 3}
[3, 9] = {3, 4, 5, 6, 7, 8, 9}
The maximum occurred integer in these ranges is 3.
 */


public class MaxOccurredIntegerInNRanges {
	// Time complexity - O(n + maxnumberinR)
	// space complexity - O(1)
    public static int maxOccured(int L[], int R[], int n){
        int [] myarray = new int[1000000];
        
        int max = -1;
        for(int i=0; i<n; i++) {
            myarray[L[i]] += 1;
            myarray[R[i] + 1] -= 1;
            
            if(R[i] > max)
                max = R[i];
        }
        
        int mostoccuring = myarray[0]; 
        int index = 0;
        for(int i = 1; i<max+1; i++) {
            myarray[i] = myarray[i] + myarray[i-1];
            if(myarray[i] > mostoccuring) {
                mostoccuring = myarray[i];
                index = i;
            }
        }
        
        return index;
        
    }
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] l = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] r = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		System.out.println("The most occurred element in the given N ranges is " + maxOccured(l,r,l.length));
	}

}
