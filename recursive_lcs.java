package recursion;
import java.util.Scanner;

public class recursive_lcs {

	static int func(String str1, String str2, int len1, int len2) {
		if (len1 == 0 || len2 == 0) {
			return 0;
		}

		if (str1.charAt(len1-1) == str2.charAt(len2-1)) {
			return 1 + func(str1, str2, len1-1, len2-1);
		} else {
			return Math.max(func(str1, str2, len1, len2-1), func(str1, str2, len1-1, len2));
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		String str1 = input.nextLine();
		String str2 = input.nextLine();

		System.out.println(func(str1, str2, str1.length(), str2.length()));

		input.close();
	}

}