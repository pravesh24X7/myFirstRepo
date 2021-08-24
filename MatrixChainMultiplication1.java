package recursion;

import java.util.Scanner;

public class MatrixChainMultiplication1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] arr = new int[input.nextInt()];

		for (int i=0; i<arr.length; i++) {
			arr[i] = input.nextInt();
		}

		System.out.println(func(arr, 1, arr.length-1));
	
		input.close();
	}

	static int func(int[] arr, int i, int j) {
		if (i >= j) return 0;
		int min_idx = Integer.MAX_VALUE;
		for (int k=i; k<=j-1; k++) {
			var tmp = func(arr, i, k) + func(arr, k+1, j) + (arr[i-1] + arr[k] + arr[j]);
			min_idx = Integer.min(min_idx, tmp);
		}

		return min_idx;
	}

}
