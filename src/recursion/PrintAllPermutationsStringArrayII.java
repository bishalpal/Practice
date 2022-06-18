package recursion;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class PrintAllPermutationsStringArrayII {

	private static void swap(int first, int second, int[] a) {
		int temp = a[first];
		a[first] = a[second];
		a[second] = temp;
	}
	
	public static void method2(int index, int[] a, List<List<Integer>> result) {
		/* base case */
		if(index == a.length) {
			// add the current permutation (i.e. the array a) to the final result and then return
			
			ArrayList<Integer> temp = new ArrayList<>();
			for(int i: a) {
				temp.add(i);
			}
			
			result.add(new ArrayList<>(temp));
			return;
		}
		// end of base case
		
		for(int i = index; i<a.length; i++) {
			swap(i, index, a);			// swap the elements for every index with the rest of the elements of array
			method2(index+1, a, result);	// make recursive call while moving the pointer to next index.
			swap(i, index, a);			// re-swap the elements so that the next recursive calls do not have errors
		}
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3};
		List<List<Integer>> result = new ArrayList<>();
		
		method2(0, a, result);
		System.out.println(result.toString());
	}

}
