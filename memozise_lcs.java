package recursion;
import java.util.Scanner;

public class memozise_lcs {

	static int func(String str1, String str2, int len1, int len2) {
		if (len1 == 0 || len2 == 0) {
			return 0;
		}

		if (arr[len1][len2] != 0) {
			return arr[len1][len2];
		}

		if (str1.charAt(len1-1) == str2.charAt(len2-1)) {
			arr[len1][len2] = 1 + func(str1, str2, len1-1, len2-1);
			return arr[len1][len2];
		} else {
			arr[len1][len2] = Math.max(func(str1, str2, len1, len2-1), func(str1, str2, len1-1, len2));
			return arr[len1][len2];
		}

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
