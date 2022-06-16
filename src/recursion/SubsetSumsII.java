package recursion;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class SubsetSumsII {

	/*
	 * 
	 */
	public static void subsetSums(int i, int sum, int[] a, ArrayList<Integer> b, 
			List<List<Integer>> result) {
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int [] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		br.close();
		
		ArrayList<Integer> result = new ArrayList<>();
		

	}

}
