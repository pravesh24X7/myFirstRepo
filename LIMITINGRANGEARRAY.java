import java.util.Arrays;
import java.util.Scanner;

public class LIMITINGRANGEARRAY	{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] arr = new int[input.nextInt()];

		for (int i = 0; i < arr.length; i++) arr[i] = input.nextInt();

	
		System.out.println(limitingrangearray(arr));
		input.close();
	}
	
	static int limitingrangearray(int[] arr) {
		Arrays.sort(arr);
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == arr[i + 1]) return arr[i];
		}
		return 0;
	}
}
