package arrays_subarrays;
import java.util.ArrayList;
import java.util.Collections;
public class NumbersSmallerthanCurrentNumber {

	/*		Leetcode - easy
	 * Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. 
	 * That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
	 * Return the answer in an array
	 */
	
	public static int[] smallerNumbersThanCurrent(int[] nums) {
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i = 0; i<nums.length; i++) {
            temp.add(nums[i]);
        }
        
        Collections.sort(temp);
        
        int[] result = new int[nums.length];
        
        for(int i = 0; i<nums.length; i++) {
            int position = temp.indexOf(nums[i]);
            result[i] = position;
        }
        return result;
    }
	public static void main(String[] args) {
		int[] nums = {8,1,2,2,3};
		int[] result = smallerNumbersThanCurrent(nums);
		System.out.println("Result : ");
		for(int i = 0; i<result.length; i++) {
			System.out.print(result[i] + " ");
		}
		
	}

}
