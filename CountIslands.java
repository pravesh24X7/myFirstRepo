import java.util.Scanner;

public class CountIslands {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int size = input.nextInt();
		arr = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				arr[i][j] = input.nextInt();
			}
		}

		solve();
		input.close();
	}

	static int[][] arr;
	static int Count;

	public static void solve() {
	}

}
		
