import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class permute {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();

		Set<String> set = new HashSet<>();
		__permute(set, str, 0, str.length());
		System.out.println(set.size());

		input.close();
	}

	static void __permute(Set<String> set, String str, int l, int r) {
		if(l == r) {
			return;
		}
		for (int i = l; i < r; i++) {
			String tmp = interchange(str, i, l);
			set.add(tmp);
			__permute(set, tmp, l + 1, r);
			tmp = interchange(tmp, i, l);
		}
	}

	static String interchange(String str, int i, int j) {
		char[] tmp = str.toCharArray();
		var x = tmp[i];
		tmp[i] = tmp[j];
		tmp[j] = x;
		return new String(tmp);
	}
}
