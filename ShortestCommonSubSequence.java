package recursion;

import java.util.Arrays;
import java.util.Scanner;

public class ShortestCommonSubSequence {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		String str1 = input.nextLine();
		String str2 = input.nextLine();

		arr = new int[str1.length()+1][str2.length()+1];
		
		for (int[] one : arr) Arrays.fill(one, -1);
	
		System.out.println(SCS(str1, str2, str1.length(), str2.length()));
		input.close();
	}

	static int[][] arr;
	
	static int SCS(String str1, String str2, int len1, int len2) {
		if (len1 == 0 || len2 == 0) {
			return 0;
		}

		if (arr[len1][len2] != -1) {
			return arr[len1][len2];
		}

		if (str1.charAt(len1-1) == str2.charAt(len2-1)) {
			arr[len1][len2] = 1 + SCS(str1, str2, len1-1, len2-1);
			return arr[len1][len2];
		} else {
			arr[len1][len2] = Math.min(SCS(str1, str2, len1, len2-1), SCS(str1, str2, len1-1, len2));
			return arr[len1][len2];
		}
	}

}
