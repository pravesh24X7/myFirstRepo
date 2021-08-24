package recursion;

import java.util.Arrays;
import java.util.Scanner;

public class MemoziseMCM {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] t = new int[input.nextInt()];
		fillUp();
		for (int i=0; i<t.length; i++) {
			t[i] = input.nextInt();
		}

		int ans = func(t);
		System.out.println(ans);
	
		input.close();
	}
	
	static void fillUp() {
		for (int[] a : arr) {
			Arrays.fill(a, -1);
		}
	}

	static int[][] arr;

	static int func(int[] a) {
		return solve(a, 1, a.length-1);
	}

	static int solve(int[] a, int i, int j) {
		if (i == j) return 0;
		if (arr[i][j] != -1) return arr[i][j];
		int min = Integer.MAX_VALUE;
		for (int k=i; k<=j-1; k++) {
			int tmp = solve(a, i, k) + solve(a, k+1, j) + (a[i-1]*a[k]*a[j]);
			min = Integer.min(min, tmp);
		}

		arr[i][j] = min;
		return min;
	}

}
