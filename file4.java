import java.util.Scanner;

public class file4 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] arr = new int[input.nextInt()];

		for (int i=0; i<arr.length; i++) arr[i] = input.nextInt();

		int[] brr = new int[input.nextInt()];
		for (int i=0; i<brr.length; i++) brr[i] = input.nextInt();
		print(mergedArrays(arr, brr));

		input.close();
	}

	static int[] mergedArrays(int[] first, int[] sec) {
		int[] tmp = new int[first.length + sec.length];
		int i, j, k;
		i = j = k = 0;
		
		while (i < first.length && j < sec.length) {
			if (first[i] < sec[j]) {
				tmp[k] = first[i];
				i++;
			} else {
				tmp[k] = sec[j];
				j++;
			}
			k++;
		}

		while (i < first.length) {
			tmp[k] = first[i];
			i++; k++;
		}

		while (j < sec.length) {
			tmp[k] = sec[j];
			j++; k++;
		}

		return tmp;
	}

	static void print(int[] arr) {
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " " );
		}
	}

}
