import java.util.Scanner;

public class Series {
	public static void main(String[] argd) {
		Scanner input = new Scanner(System.in);
		int [] arr1 = new int[input.nextInt()];
		int [] arr2 = new int[input.nextInt()];
		int [] arr3 = new int[input.nextInt()];

		Input(arr1);
		Input(arr2);
		Input(arr3);

		System.out.println("Result : " + getResult(arr1, arr2, arr3));
		input.close();
	}

	
