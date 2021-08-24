package recursion;

import java.util.Scanner;
import java.util.Arrays;

public class LongestCommonKSubSequence {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String str1 = input.nextLine();
		String str2 = input.nextLine();
	
		sb = new StringBuffer();
		arr = new int[str1.length()+1][str2.length()+2];
		for (int[] one : arr) Arrays.fill(one, -1);

		System.out.println(LCS(str1, str2, str1.length(), str2.length(), input.nextInt()));
		System.out.println(sb);
		
		input.close();
	}

	static StringBuffer sb;
	static int[][] arr;

	static int LCS(String str1, String str2, int len1, int len2, int k) {
		if (len1 == 0 || len2 == 0 || k == 0) {
			return 0;
		}

		if (arr[len1][len2] != -1) return arr[len1][len2];

		if (str1.charAt(len1-1) == str2.charAt(len2-1)) {
			sb.append(str1.charAt(len1-1));
			arr[len1][len2] = 1 + LCS(str1, str2, len1-1, len2-1, k-1);
			return arr[len1][len2];
		} else {
			arr[len1][len2] = Math.max(LCS(str1, str2, len1, len2-1, k), LCS(str1, str2, len1-1, len2, k));
			return arr[len1][len2];
		}
	}

}	
