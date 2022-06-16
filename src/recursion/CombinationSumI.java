package recursion;
import java.util.List;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.IOException;
import java.io.InputStreamReader;

public class CombinationSumI {

	/*
	 * Generally interviewer won't ask for T.C. and S.C for recursive problems but if he does, 
	 * then say T.C. will be exponential.
	 * 
	 * Time complexity : O(2^t * k)
	 * if an element could not be picked multiple times, then the T.C. would have been 2^n 
	 * but here, we can pick a single element any number of times; so, we can generalize it for the 'n' elements
	 * as 't' times; hence 2^t
	 * 
	 * here k is the average length of the combinations we find. We have to add the combination we find into
	 * another data structure which takes O(k) time
	 * 
	 * 
	 * Space complexity : variable ... as it depends on the number of combinations I will have if I ignore the
	 * 					  auxillary space that recursion takes; because I am not sure how many combinations I
	 * 					  will have.
	 * 						k * x
	 * 						where k is the avg length of combination
	 * 						where x is the number of combinations.
	 */
	public static void findCombinations(int i, int target, int[] a, List<List<Integer>> result, 
			ArrayList<Integer> ds) {
		
		// base case		
		if(i == a.length) {
			if(target == 0) {
				result.add(new ArrayList<>(ds));				// this task takes linear time. DO NOT THINK IT AS CONSTANT TIME.
			}
			return;
		}
		
		// pick the element
		if(a[i] <= target) {	// if the current element is <= target only then proceed with picking the element
			ds.add(a[i]);										// add the particular element to the ds
			
			findCombinations(i,target-a[i], a, result, ds);		// we don't increment i by 1 since we want to pick
																// it again in the next iteration.
																// we reduce the target by the value we have
																// picked up
			ds.remove(new Integer(a[i]));			// after returning from the recursive call, we need to remove 
													// the added element from our data structure i.e. ds
		}
		
		// not pick the element
		findCombinations(i+1, target, a, result, ds);	// since I am not adding the element to the ds; I don't 
														// need to subtract it from "target"
		
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int [] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int target = Integer.parseInt(br.readLine());
		br.close();
		
		List<List<Integer>> result = new ArrayList<>();
		
		findCombinations(0, target, a, result, new ArrayList<Integer>());
		System.out.println(result.toString());
		
	}

}



/*
 * in case the method function looked like this, then code will be -
  public void findCombinations(int i, int[] a, int target, List<List<Integer>> result, 
  								List<Integer> ds) {
  		if(i == a.length) {
  			if(target == 0) {
  				result.add(new ArrayList<>(ds));
  			}
  			return;
  		}
  		
  		// pick element
  		if(a[i] <= target) {
  			ds.add(a[i]);
  			findCombinations(i, a, target-a[i], result, ds);
  			ds.remove(ds.size() - 1);
  		}
  		findCombinations(i+1, a, target, result, ds);
  }
  
 */
  

