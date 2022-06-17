package recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPermutationsStringArrayI {

	/*
	 * There are 2 methods to solve this problem. This is method 1. It uses extra space.
	 * 
	 */
	public static void method1(ArrayList<Integer> ds, boolean [] map, List<List<Integer>> result, int [] a) {
		if(ds.size() == a.length) {
			result.add(new ArrayList<>(ds));
			return;
		}
		
		for(int i = 0; i<a.length; i++) {
			if(!map[i]) {				// if map does not have the 'i' index checked => we can take that element
				
				// add the element and set the map index i as true.
				ds.add(a[i]);
				map[i] = true;
				
				// make the recursive call.
				method1(ds, map, result, a);
				
				// remove the element from the ds and uncheck the map for that particular element.
				ds.remove(new Integer(a[i]));
				map[i] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3};
		boolean [] map = new boolean[a.length];
		List<List<Integer>> result = new ArrayList<>();
		
		method1(new ArrayList<Integer>(), map, result, a);
		
		System.out.println(result.toString());

	}

}
