package binarysearch;

import java.util.Scanner;

public class CountNegativeNumbersSortedMatrix {
	
	// recursive binary search -- much simpler to write.
	public static int lastNegativeElementIndex(int[] row,  int start, int end) {
		
		if(start == end)				// base condition 
			return start;
		int mid = (end - start) / 2;
		
		// if the element at index 'mid' is negative
		if(row[mid] < 0) {
			// if the -ve element is the last
			if(mid+1 <row.length && row[mid+1] >= 0) {
				return mid;
			}
			else {		// i.e. if the row[mid] is not the last, it means we need to search on the right side of row.
				return lastNegativeElementIndex(row, mid+1, end);
			}
		}
		// in case the element at index 'mid' is not -ve, 
		// we need to check in the left half of the row since row is sorted.
		else {
			return lastNegativeElementIndex(row, start, mid-1);
		}		
	}
	
	
	public static int countNegatives(int[][] grid) {
		
		/* Approach 1 - use 2 loops. Time complexity -  O(m*n) where m = #rows | n = #cols		  
		int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i<m; i++ ) {
            for(int j = 0; j<n; j++)
                if(grid[i][j] <0)
                    count++;
        }
        return count;
		*/ 
		
		
		/* Efficient approach - use binary search on each row to find the last -ve element. 
		 * 						We can keep track of the count.
		 * of -ve numbers in each iteration.
		 * 			note =>   #rows = m | #cols = n
		 * Time complexity - m*O(logn)		Space complexity= O(1)
		 * 
		 * */
		
		int count = 0;
		int m = grid.length;
		int n = grid[0].length;
		int index = n-1;				// initially, we will do binary search on the entire 1st row of matrix from index 
										// 0 to 'index'. But in next searches, we don't need to do search entire row.
		
		for(int i = 0; i < m; i++) {
			if(grid[i][0] >= 0)			// matlab pahela element agar >=0 hua, then no need to find -ve elements anymore.
				return count;
			else {
				index = lastNegativeElementIndex(grid[i], 0, index);
				count += index + 1;
			}
		}				
		return count;
	}
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of rows of grid : ");
		int m = sc.nextInt();
		System.out.println();
		System.out.print("Enter number of cols of grid : ");
		int n = sc.nextInt();
		System.out.println();
	
		int[][] grid = new int[m][n];
		
		System.out.println("Enter the sorted values for the matrix (increasing order - row wise & col wise) :");
		for(int i = 0; i<m; i++) {
			for(int j = 0; j<n; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		sc.close();
		System.out.println("The number of negative numbers in the sorted matrix are : " + countNegatives(grid));
	}

}
