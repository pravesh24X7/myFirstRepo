import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

// Code isn't working fine but the concept used to solve the question is working :) ok!!!

public class OmkarAndBadStory {
	public static void main(String[] args) {
	        input = new Scanner(System.in);
		list = new LinkedList<>();
		int tc = input.nextInt();
		
		while (tc > 0) {
			func();
			tc--;
		}		
/**		
		int[] arr = new int[input.nextInt()];
		for(int i=0; i<arr.length; i++) {
			arr[i] = input.nextInt();
		}
*/		
		System.out.println(list);
		input.close();

	}

	
	static List<String> list;
	static Scanner input;


	static void  func() {
		input = new Scanner(System.in);
		int[] arr = new int[input.nextInt()];

		for (int i=0; i<arr.length; i++) arr[i] = input.nextInt();		

		Set<Integer> set = new HashSet<>();
		for(var item:arr) {
			set.add(item);
		}
		boolean flag = true;

		Arrays.sort(arr);
		for (int i=0; i<arr.length; i++) {
			int j=i+1;
			while (j+1 < arr.length && j > 0) {
				if (!set.contains(arr[j]-arr[j-1])) {
					flag = false;
				}			
				j--;
			}
			if (flag)list.add("yes");else list.add("no");
		}
		input.close();
	}

}
