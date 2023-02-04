package binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

public class MedianOfTwoSortedArrays {
	public static int naiveApproach(int[] a, int[] b) {
		
		return 0;
	}
	
	public static double efficientApproach(int[] a, int[] b) {
		int n1 = a.length;
		int n2 = b.length;
		if(n2 < n1)						// we can skip this as well. This step helps us in performing binary search
			efficientApproach(b, a);	// on the smaller size array. This gives us T.C O(log(Min(n1,n2)))
		
		int low = 0;
		int high = n1;
		
		while(low <= high) {
			/* if we imagine a cut at the middle of a sorted array, it can be said that all the elements from 
			the left of cut is smaller than all the elements on the right of the cut.
			
			we make 2 cuts on both arrays to gain the parts of the array - using the left and right parts of both the arrays
			we can assume the left side of the cut and right side of the cut of our merged array(sorted array formed from 
			combining both a[] and b[]) */
			
			int cut1 = (low + high) >> 1;
			int cut2 = (n1 + n2 + 1)/2 - cut1;		// we can write (n1+n2)/2 - cut1, 
													// but this stmt. can help for both odd and even values of (n1 + n2)
			
			
			int left1 = cut1 == 0 ? Integer.MIN_VALUE : a[cut1 - 1];	// the last element of selected left-side of 1st array
			int left2 = cut2 == 0 ? Integer.MIN_VALUE : b[cut2 - 1];	// the last element of selected left-side of 2nd array
			
			int right1 = cut1 == n1 ? Integer.MAX_VALUE : a[cut1];		// the first element of selected right-side of 1st array
			int right2 = cut2 == n2 ? Integer.MAX_VALUE : b[cut2];		// the first element of selected right-side of 2nd array
			
			
			/*
			 * this is the most imp. part. 
			 * we know that the a[] has been cut at cut1. Now, the left1 is obviously going to be smaller than right1.
			 * because both are elements of same array. same goes for left2 and right2.
			 * 
			 * we need to check if (left1 <= right2) AND (left2 <= right1) 
			 * this is to ensure that the cuts cut1 and cut2 are at correct positions in a[] and b[] otherwise we
			 * are making our resultant array (sorted merged array of a[] and b[])
			 * */
			
			if(left1 <= right2 && left2 <= right1) {
				if((n1+n2)%2 == 0)		// i.e merged array is of even size, then need to take avg. of 2 elements.
					return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
				else
					return Math.max(left1, left2);				// odd size, so only 1 element,
			}
			else if(left1 > right2) {			// matlab, jo humne cut1 maara usme left1 element bada hai as compared to right2
				high = cut1 -1;					// so humko reduce karna hoga left1 ka value. This is possible if we move our cut1 to
												// the left side. So, we reduce the high to cut1 -1.
			}
			else {
				low = cut1 + 1;					// yaha left2 > right1, so humko right1 ka value increase karna hoga
			}									// so we move the low to cut1 - 1. Next time when cut1 is calculated, it will have its 
												// value increased. (see how cut1 is calculated at the beginning of loop)	
		}		
		return 0.0;			// although this stmt. will never be executed since both arrays are sorted. but 
							// we have to write it because how method returns a double value.
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// take input of arrays from user.
		System.out.println("Enter first sorted array elements  : ");
		int [] arr1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();	
		System.out.println("Enter second sorted array elements  : ");
		int [] arr2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		br.close();
		
		// naive approach
		System.out.println("Median of the 2 sorted arrays is " + naiveApproach(arr1, arr2));
		
		// efficient approach
		System.out.println("Median of the 2 sorted arrays is " + efficientApproach(arr1, arr2));

	}

}
