import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;

public class SubArrayWithSumZero {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int[] arr = new int[input.nextInt()];	
		for (int i = 0; i < arr.length; i++) {
			arr[i] = input.nextInt();
		}
		int sum = input.nextInt();
		
		List<List<Integer>> items = new LinkedList<>();
		ZeroSumSubArray(arr, 0, arr.length - 1, sum, items);
		System.out.println(items);
		input.close();
	}

	static void ZeroSumSubArray(int[] arr, int left, int right,int sum, List<List<Integer>> items) {
		if (left < right) {
			if (arr[left] + arr[right] == sum) {
				List<Integer> tmp = new LinkedList<>();
				tmp.add(arr[left]);
				tmp.add(arr[right]);
				items.add(tmp);
				left++; right--;
				ZeroSumSubArray(arr, left, right, sum, items);
			} else if (arr[left] + arr[right] < sum) {
				left++;
				ZeroSumSubArray(arr, left, right, sum, items);
			} else if (arr[left] + arr[right] > sum) {
				right--;
				ZeroSumSubArray(arr, left, right, sum, items);
			 }
		}
	}
	
}		
