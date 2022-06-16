package recursion;
import java.util.List;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.IOException;
import java.io.InputStreamReader;

public class CombinationSumII {
	// Brute force approach is at the end of the program
	/*
	 * Conditions I - can't take 1 element more than once 
	 * Condition II - combinations need to be sorted and should be stored in lexicographical order in final result.
	 * Condition III - No duplicate combinations should be stored in the final result.
	 * 
	 * Algorithm -
	 * 1. Sort the array so that the combinations we create will have elements in sorted order.
	 * 2. our recursive function will need to keep a track of index, target_sum, a DS to store the combination,
	 * 	  a DS to store all the combinations possible.
	 * 3. 
	 * 
	 * 
	 * 
	 * Time complexity : O(2^n * k)  
	 * 					assume all elements of array to be unique.
	 * 					then, 2^n because every element can be picked only once
	 * 					k is the average length of the combination. Since we are adding a combination to result
	 * 				    it requires O(k) time
	 * 
	 * Space complexity : k * x			(ignoring the auxiliary space that recursion takes)
	 * 					  x = number of possible combinations.
	 */
	public static void findCombinations(int index, int target, int [] a, List<List<Integer>> result, 
			ArrayList<Integer> ds) {
		// base case
		if(target == 0) {
			result.add(new ArrayList<>(ds));				// a linear time operation
			return;
		}
		
		// creating the combinations
		for(int i = index; i < a.length; i++) {
			/* to not create duplicate combinations
			 * 
			 * a[i] == a[i-1] is used to check if it is second repetitive element or 3rd repetitive element
			 * i > index is to not lose out on the repetitive element as the next element for our combination.
			 * see the video at 26:25
			 */
			if(i > index && a[i] == a[i-1]) continue;
			
			/* if the element we are going to choose is greater than the "target", then we can return
			   since the elements from here after will ALWAYS be greater than "target" (...since array is sorted)*/
			if(a[i] > target) break;
			
			/* pick the current element */
			ds.add(a[i]); 				
			
			/*
			 * here we do i+1 instead of (index + 1) because, after selecting 1 element we loop through the entire
			 * array after the element at index i.
			 * target is reduced by a[i] since we are picking it in our combination.
			 * */
			findCombinations(i+1, target - a[i], a, result, ds);
			
			/* remove the picked element. */
			ds.remove(new Integer(a[i]));
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int [] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int target = Integer.parseInt(br.readLine());
		br.close();
		
		List<List<Integer>> result = new ArrayList<>();
		// sort the array first.
		Arrays.sort(a);
		
		findCombinations(0, target, a, result, new ArrayList<Integer>());
		System.out.println(result.toString());		

	}

}


/*
 * Brute force approach -
 * use the approach of CombinationSumI, but some modifications are needed
 * 1. since 1 element can't be used more than once, so we can't stay at the same index after picking an element.
 * 	  so, we have to increment the value of i by 1
 * 2. Since no duplicate combinations are allowed, we need to use a HashSet to store the possible combinations
 *    because List<List<Integer>> won't avoid duplicates. After returning from the method findCombinations(),
 *    we can convert the HashSet into a List<List<Integer>> in the main().
 *    
 * Time complexity : O( 2^t * k * logp)
 * 						k is the average size of the combination
 * 						p is the size of HashSet. log(p) time is required extra since we are inserting into a 
 * 						HashSet instead of a List<List<Integer>>.
 * */
