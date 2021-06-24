import java.util.Scanner;

public class fun_fun {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int n = input.nextInt();
		int[] arr = new int[n];

		for (int i=0; i < n; i++) {
			arr[i] = input.nextInt();
		}

		System.out.println("Res : " + result(arr));
		input.close();
	}

	public static int result(int[] arr) {
		int ans = 0;
		for (int i=0; i<arr.length; i++) {
			if (i%2 == 0) {
				ans += arr[i];
			}
		}
		return ans;
	}
}

