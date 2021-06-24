import java.util.Scanner;

public class spiral {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[][] arr =  new int[input.nextInt()][input.nextInt()];

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr[0].length - 1; j++) {
				arr[i][j] = input.nextInt();
			}
		}
		traversal(arr, arr.length - 1, arr[0].length - 1);
		input.close();
	}

	static void traversal(int[][] arr, int row, int cols) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(arr[i][j] + " " );
				if (i == row-1) {
					j = 1;
					System.out.print(arr[j][i] + " " );
				}
			}
		}	
	}
}

