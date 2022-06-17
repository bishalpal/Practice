package recursion;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class SubsetSumsII {

	/*				MAKE THE RECURSIVE TREE TO GET A BETTER IDEA.
	 * our recursive function will have an index_of_the_element to be picked, a DS to store the picked elements,
	 * the final result DS and the input array.
	 * 
	 * we need to sort the input array before making the first call to the recursive function. This is done because
	 * we have to avoid duplicate subsets. So, if we sort the array beforehand, we get all the duplicate elements
	 * placed side by side. In the recursive call we can skip them as per our logic.
	 * 
	 * at each recursive call, we create a list (which is one of the subsets) and store it into final result.
	 * 
	 * now, how to pick the elements for the list (i.e. subset) -
	 * 		first, we check if it is the first time to pick the element (i.e. the condition i != index fails here)
	 * 		even if the a[i] == a[i-1] holds true (suppose, same value elements are present at both indexes.)
	 *		So, next time we encounter a duplicate value, the i!=index goes true, hence we continue looping
	 * 
	 *		Now, if it is the first time to pick an element, then add it to the 'ds' and then call the recursive function
	 *		for i+1 index; this is because, we have picked the element at index 'i' and now we need to pick the next
	 *		element for the subset of size 1 greater than the current one.
	 *
	 *		After returning from the function call, we must remove the added element	
	 *
	 *		Time complexity : O( 2^n * n)
	 *						  2^n for recursion
	 *						  *n is because, every time we make a recursive call, we put the 'ds' into 'result' which is
	 *						  a linear time operation. (assuming that every subset is near about size 'n')
	 *		Space complexity : O(2^n) * O(k)
	 *						   we will have 2^n subsets. Each subset will have a length 'k' suppose
	 *							O(n) - auxiliary space required by recursion. it is 'n' because it is the depth of 
	 *								   recursive tree.
	 */
	public static void subsetSums(int index, int[] a, ArrayList<Integer> ds, 
			List<List<Integer>> result) {
		result.add(new ArrayList<>(ds));
		
		for(int i = index; i<a.length; i++) {
			if(i!=index && a[i] == a[i-1]) continue;
			ds.add(a[i]);
			subsetSums(i+1, a, ds, result);
			ds.remove(new Integer(a[i]));
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int [] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		br.close();
		
		List<List<Integer>> result = new ArrayList<>();
		
		Arrays.sort(a);
		
		// initial call - a list (i.e. a subset) of size 0, starting at index 0.
		subsetSums(0, a, new ArrayList<Integer>(), result);
		
		System.out.println(result.toString());

	}

}
