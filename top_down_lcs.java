package recursion;

import java.util.Scanner;

public class top_down_lcs {

	static int func(String str1, String str2, int len1, int len2) {

		// base condition of dp
		for (int i=0; i<=len1; i++) {
			for (int j=0; j<=len2; j++) {
				if (i == 0 || j == 0) {
					arr[i][j] = 0;
				}
			}
		}

		for (int i=1; i<=len1; i++) {
			for (int j=1; j<=len2; j++) {
				if (str1.charAt(i-1) == str2.charAt(j-1)) {
					arr[i][j] = 1 + arr[i-1][j-1];
				} else {
					arr[i][j] = Math.max((arr[i-1][j]), (arr[i][j-1]));
				}
			}
		}

		return arr[len1][len2];
	}

	static int[][] arr;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		String str1 = input.nextLine();
		String str2 = input.nextLine();

		arr = new int[str1.length()+1][str2.length()+1];

		System.out.println(func(str1, str2, str1.length(), str2.length()));

		input.close();
	}

}
