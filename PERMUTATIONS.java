import java.util.Scanner;

public class PERMUTATIONS {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String __init__ = input.next();
	
		System.out.println(permutations(__init__, 0, __init__.length() - 1));
		input.close();
	}
	
	private static int permutations(String __init__, int l, int r) {
		if (l == r) {
			return count++;
		}
		for (int i = l; i <= r; i++) {
			permutations(interchange(__init__, i, l), l+1, r);
			interchange(__init__, i, l);
		}
		return count;
	}
	
	static int count = 0;
	
	private static String interchange(String __init__, int a, int b) {
		char[] arr = __init__.toCharArray();
		var tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
		return String.valueOf(arr);
	}
}
