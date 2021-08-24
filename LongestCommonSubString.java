package recursion;

import java.util.Scanner;

public class LongestCommonSubString {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String str1 = input.nextLine();
		String str2 = input.nextLine();

		System.out.println(LCSS(str1, str2, str1.length(), str2.length()));

		input.close();
	}

	static int[][] arr;
		
	static int LCSS(String str1, String str2, int l1, int l2) {
		int k=0;
		StringBuffer sb = new StringBuffer();
		String ans_str = "";
		int ans_len = 0;

		for (int i=0; i<l1; i++) {
			for (int j=0; j<l2; j++) {
				if (str1.charAt(i) == str2.charAt(j)) {
					k++;
					sb.append(str1.charAt(i));
				} else {
					k=0;
					sb = new StringBuffer();
				}
				var replica = ans_len;
				ans_len = Math.max(ans_len, k);
				if (replica != ans_len) {
					ans_str = new String(sb);
				}
			}
		}

		System.out.println(ans_str);
		return ans_len;
	}

}
