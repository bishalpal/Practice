package binarysearch;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SearchInRotatedSortedArray {
	/*
	 * Problem - There is an integer array nums sorted in ascending order (with distinct values).
	   Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) 
	   such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). 
	   For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2]. 
	   Given the array nums after the possible rotation and an integer target, return the index of target if it is 
	   in nums, or -1 if it is not in nums.
	   You must write an algorithm with O(log n) runtime complexity.
	   
	   efficient approach - T.C = O(logn), S.C = O(1)
	   let the array be [4,5,6,7,0,1,2].		target = 0
	   since the array is sorted, we can use binary search. Now, this array is not sorted entirely since it has
	   been rotated.
	   Observation - If we stand at any index in array, say 3. 
	   				 Now, there are 2 halves, left half (from index 0 to 3) and right half (from index 4 to n-1)
	   				 we can say that the left half is sorted if
	   				 a[0] < a[3]
	   				 we can say that the right half is sorted if 
	   				 a[4] < a[n-1]
	   				 
	   				 Now, we can check if the target element is in left half if a[0] <= target <= a[3]
	   				 if it is not, then check in right half.
	   				 
	   The above observation is the general idea.
	   				 
	 */
	public static int efficientApproach(int[] a, int target) {
		int low = 0;
		int high = a.length -1;
		while(low <= high) {
			int mid = (low + high) >> 1;
			if(a[mid] == target) {
				return mid;				
			}
			
			if(a[low] <= a[mid]) {								// i.e. left side is sorted
																// check if target element lies in left side
				if(a[low] <= target && target <= a[mid]) 
					high = mid -1;								// matlab ki target element hai 
				else 
					low = mid + 1;								// target nahi hai left side mein, so check in right half.							
			}
			else {												// right side is sorted
				if(target >= a[mid] && target <= a[high]) 		// check if target appears in right half.
					low = mid + 1;								// matlab target right side mein hai.
				else
					high = mid - 1;								
			}
		
		}
		return -1;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//take sorted and rotated array input from user.
		System.out.println("Enter sorted and rotated array elements  : ");
		int [] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		// take the element to find from user.
		System.out.println("Enter the target element to find in the array : ");
		int target = Integer.parseInt(br.readLine());
		br.close();
		
		int result = efficientApproach(arr, target);
		if(result == -1)
			System.out.println("Target element on present in the array.");
		else
			System.out.println("The element is present at index : "+ result);
	}

}
