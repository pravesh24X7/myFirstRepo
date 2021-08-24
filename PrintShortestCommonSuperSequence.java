package recursion;

import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


public class PrintShortestCommonSuperSequence {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		String str = input.nextLine();
		String str2 = input.nextLine();

		arr = new int[str.length() + 1][str2.length() + 1];
		fillUp();
		System.out.println(solve(str, str2));
		System.out.println(PSS(str+str2));

		input.close();
	}

	static String lcsString;
	static int[][] arr;

	static void fillUp() {
		for (int[] a : arr) {
			Arrays.fill(a, -1);
		}
	}

	static String PSS(String first) {
		List<Character> forFirst = new ArrayList<>();

		for (var f : first.toCharArray()) {
			forFirst.add(f);
		}

		for (var c : lcsString.toCharArray()) {
			if (forFirst.contains(c)) {
				forFirst.remove(forFirst.lastIndexOf(c));
			}
		}

		StringBuilder str = new StringBuilder();
		for (var f : forFirst) {
			str.append(f);
		}

		return str.toString();
	}

	static int solve(String str1, String str2) {
		return (str1.length() + str2.length()) - LCS(str1, str2, str1.length(), str2.length());
	}

	static int LCS(String str1, String str2, int l1, int l2) {
		for (int i = 0; i <= l1; i++) {
			for (int j = 0; j <= l2; j++) {
				if (i == 0 || j == 0) arr[i][j] = 0;
				else if (str1.charAt(i-1) == str2.charAt(j-1)) arr[i][j] = 1 + arr[i-1][j-1];
				else arr[i][j] = Integer.max(arr[i-1][j], arr[i][j-1]);
			}
		}

		int index = arr[l1][l2];
		char[] lcs = new char[index+1];

		lcs[index] = '\u0000';

		int i = l1;
		int j = l2;

		while (i > 0 && j > 0) {
			if (str1.charAt(i-1) == str2.charAt(j-1)) {
				lcs[i - 1] = str1.charAt(i - 1);
				i--;
				j--;
				index--;
			}
			else if (arr[i-1][j] > arr[i][j-1]) i--; else j--;
		}

		lcsString = new String(lcs);
		return arr[l1][l2];
	}

}
