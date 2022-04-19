package arrays_subarrays;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
public class MajorityElement {

	public static int naiveapproach(int [] a) {
		int count = 1;
		for(int i = 0; i<a.length; i++) {
			count = 1;
			for(int j = i+1; j<a.length; j++) {
				if(a[i] == a[j])
					count++;
			}
			if(count > a.length/2)
				return i;
		}
		return -1;
	}
	
	public static int efficientapproach(int[] a) {
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i = 0; i<a.length; i++) {
			if(map.containsKey(a[i])) {
				int count = map.get(a[i])+1;
				if(count > a.length/2) 
					return i;
				else
					map.put(a[i], count);
			}
			else
				map.put(a[i], 1);
		}

		return -1;
	}
	
	public static int mooreVotingAlgo(int [] a) {
		int res = 0;
		int count = 1;
		// stage 1 - finding the candidate - index of the candidate for majority element stored in "res"
		for(int i = 1; i<a.length; i++) {
			if(a[i] == a[res])
				count++;
			else
				count--;
			if(count == 0) {
				res = i;
				count = 1;
			}
		}
		
		// stage 2 - verifying whether the candidate given by stage 1 is a majority element or not
		
		for(int i = 0; i<a.length; i++) {
			if(a[i] == a[res])
				count++;
		}
		if(count > a.length/2)
			return res;
		
		return -1;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		// naive approach - 2 loops : Time - O(n^2), space - O(1)
		System.out.println("The majority element in the array is at index " + naiveapproach(a) + " and it's value is "+ a[naiveapproach(a)]);
		
		// efficient approach - hashmap : Time and Space - O(n)
		System.out.println("The majority element in the array is at index " + efficientapproach(a) + " and it's value is "+ a[efficientapproach(a)]);
		
		// most efficient approach - moore's voting algo : Time - O(n), Space - O(1)
		System.out.println("The majority element in the array is at index " + mooreVotingAlgo(a) + " and it's value is "+ a[mooreVotingAlgo(a)]);
		
	}

}
