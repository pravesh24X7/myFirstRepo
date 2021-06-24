import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

public class FINDPAIRWITHGIVENSUM {
	static int counter = 0;

	private static void numofways(int[] arr, int l, int r, int sum) {
		if (l < r) {
			if (arr[l] + arr[r] == sum) {
				counter++;
				l++; r--;
				numofways(arr, l, r, sum );
			}
			else if (arr[l] + arr[r] > sum) {
				r--;
				numofways(arr, l, r, sum );
			}
			else if (arr[l] + arr[r] < sum) {
				l++;
				numofways(arr, l, r, sum);
			}
			
		}
	}
		

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int[] arr = new int[input.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = input.nextInt();
		}
 		int sum = input.nextInt();
		Arrays.sort(arr);
		List<Integer> ll = new LinkedList<>();
		
		pairwithsum(arr,0, arr.length - 1, sum, ll);
		System.out.println(ll);

		numofways(arr, 0, arr.length - 1, sum);
		System.out.println(counter);
		input.close();
	}

	private static void pairwithsum(int[] arr, int l, int r, int sum, List<Integer> ll) {
		if (l < r) {
			if (arr[l] + arr[r] == sum) {
				ll.add(arr[l]);
				ll.add(arr[r]);
				return;
			}
			else if (arr[l] + arr[r] < sum) {
				l++;
				pairwithsum(arr, l, r, sum, ll);
			}
			else if (arr[l] + arr[r] > sum) {
				r--;
				pairwithsum(arr, l, r, sum, ll);
			}
		} return;
	}
}
				 
