import java.util.Scanner;

public class sort_array {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		sort_array(input.nextInt());
		
		for (int i = 0; i<size; i++) {
			add(input.nextInt());
		}

		sort();
		print();

		input.close();
	}

	static int[] arr;
	static int top, size, capacity;

	static sort_array(int capacity) {
		this.capacity = capacity;
		top = -1;
		size = 0;
		arr = new int[capacity];
	}

	private static void add(int item) {
		if (is_full()) {
			return;
		}
		size++;
		arr[++top] = item;
		return;
	}

	public static boolean is_full() {
		return size == capacity;
	}

	public static boolean is_empty() {
		return size == 0;
	}

	public static void print() {
		if (is_empty()) {
			return;
		}
		for (int i = top; i >= 0; i--) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void sort() {
		if (is_empty()) {
			return;
		}
		for (int i = 1; i<size; i++) {
			int j = i;
			if (arr[j] < arr[j-1]) {
				while (j>0 && arr[j] < arr[j-1]) {
					swap(arr, j, j-1);
					j--;
				}
			}
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
}
