package binarysearch;

import java.util.Scanner;

public class CountNegativeNumbersSortedMatrix {

	public static int countNegatives(int[][] grid) {
		/* Approach 1 - use 2 loops. Time complexity -  O(m*n) where m = #rows | n = #cols
		 */ 
		int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i<m; i++ ) {
            for(int j = 0; j<n; j++)
                if(grid[i][j] <0)
                    count++;
        }
        return count;
		 
		
		
		/* Approach 2 - use 2 loops but
		 * */
		
		
		
		
		
//		int count = 0;
//		
//		return count;
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
		
		System.out.println("The number of negative numbers in the sorted matrix are : " + countNegatives(grid));
	}

}
