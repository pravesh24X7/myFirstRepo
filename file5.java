import java.util.Scanner;

public class file5 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] arr = new int[input.nextInt()];

		for (int i=0; i<arr.length; i++) {
			arr[i] = input.nextInt();
		}
		mergeSort(arr, 0, arr.length-1);
		print(arr);
	
		input.close();
	}

	static void mergeSort(int[] arr, int lower, int upper) {
		if (lower < upper) {
			int mid = (upper + lower) / 2;
			mergeSort(arr, lower, mid);
			mergeSort(arr, mid+1, upper);
			merge(arr, lower, mid, upper);
		}
	}

	static void merge(int[] arr, int lower, int mid, int upper) {
		int[] tmp = new int[upper+1];
		int i, j, k;
		i = k = lower;
		j = mid+1;

		while (i <= mid && j <= upper) {
			if (arr[i] < arr[j]) {
				tmp[i] = arr[i];
				i++;
			} else {
				tmp[j] = arr[j];
				j++;
			}
			k++;
		}

		while (i <= mid) {
			tmp[k] = arr[i];
			i++; k++;
		}

		while (j <= upper) {
			tmp[k] = arr[j];
			j++; k++;
		}

		System.arraycopy(tmp, 0, arr, 0, tmp.length-1);
	}

	static void print(int[] arr) {
		for (int i : arr) System.out.print(i + " " );
	}

}
