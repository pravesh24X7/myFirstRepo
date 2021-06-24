import java.util.Scanner;

public class file2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); 
		int[] arr = new int[input.nextInt()];
		
		for (int i=0; i<arr.length; i++) {
			arr[i] = input.nextInt();
		}
		System.out.println(getMaxSubArraySum(arr));

		input.close();
	}

	static int getMaxSubArraySum(int... arr) {
		int ans = Integer.MIN_VALUE;
		int sum = 0;

		for (int i=0; i<arr.length; i++) {
			sum += arr[i];
			if (sum < 0) {
				sum = 0;
			}
			ans = Math.max(ans, sum);
		}
		return ans;
	}

}
