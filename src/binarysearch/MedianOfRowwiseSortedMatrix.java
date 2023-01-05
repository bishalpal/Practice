package binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;
public class MedianOfRowwiseSortedMatrix {
	
	/* This function counts the #elements smaller than 'mid' in each row of the matrix and then returns the #.
	 * To find this, we use binary search again since it is a row wise sorted matrix.
	 * 
	 * if I am able to find the index of the element which is greater than mid, then that index = #elements 
	 * smaller than 'mid'.
	 * So, the question becomes find the 'ind' such that a[ind] > mid.
	 * 
	 * 
	 * To understand this better, refer to 17:17 in TUF
	 */
	public static int NumberOfElementsSmallerThanMid(int matrix[], int mid) { 		// O(log(columns))
		int l = 0;
		int h = matrix.length - 1;
		
		while(l<h) {
			int m = (l + h) >> 1;
			if(matrix[m] <= mid)
				l = m + 1;
			else
				h = m - 1;
		}
		
		return l;
	}
	
	
	
	public static void main(String[] args) throws IOException {
		int r = 3;
		int c = 3;
		//taking row wise sorted matrix 3*3 input for simplicity.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] matrix = new int[r][c];
		System.out.println("Enter the values of row wise sorted matrix : ");
		for(int i = 0; i<3; i++) {		// just make sure to insert elements of rows in separate lines.
			matrix[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		br.close();
		
		
		// Step 1 : Find min, max element in the matrix.
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for(int j = 0; j<3; j++) {
			min = Math.min(matrix[0][j], min);
			max = Math.max(max, matrix[j][2]);
		}
		
		// Step 2 : we do binary search in the range [min, max].
		int elementsOnBothSidesOfMedian = (r*c + 1) >> 1;			// divide by 2.
		while(min < max) {
			int mid = (min + max) >> 1;					// i am getting infinite loop if I use (min + (max-min)) >>1

			int countOfElements = 0;
			
			// Now, we search the #elements smaller than the mid.
			for(int i = 0; i<r; i++) {								// T.C = rows * O( NumberOfElementsSmallerThanMid())
																	// i.e. O(rows * log(columns)) ...binary search
				countOfElements += NumberOfElementsSmallerThanMid(matrix[i], mid);	
			}
			/*
			 * For debugging
			 * System.out.println("min = " + min + " max = "+ max + " mid = " + mid + "countOfElements = " + countOfElements);
			*/
			if(countOfElements < elementsOnBothSidesOfMedian)
				min = mid + 1;
			else
				max = mid - 1;
			
		}
		System.out.println("Median is " + min);

	}

}
