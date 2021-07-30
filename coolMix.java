package coreJava;
import java.util.Scanner;

public class coolMix {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		
		int[][] arr = new int[n][n];
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				arr[i][j] = input.nextInt();
			}
		}

		pattern1(arr);
		input.close();
	}

	static void pattern1(int[][] arr) {
		for (int i=0; i<arr.length; i++) {
			for (int j=0; j<arr[0].length; j++) {
				System.out.print(arr[j][i] + " " );
			}
		}
	}

}

