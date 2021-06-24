import java.util.Scanner;

public class ARRAYREPRESENTAMINHEAP {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] arr = new int[input.nextInt()];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = input.nextInt();
		}
		System.out.println(arrayrepresentaminheap(arr));
		input.close();
	}

	private static boolean arrayrepresentaminheap(int[] arr) {

		for (int i = 0; i <= (arr.length - 2) / 2 ; i++) {
			if (arr[i] > arr[2 * i + 1] || (2 * i+2) != arr.length && arr[i] > arr[2 * i+2]) return false;
		}
		return true;
	}
}
