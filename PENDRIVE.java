import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class PENDRIVE {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] arr = new int[input.nextInt()];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = input.nextInt();
		}
		
		
		Remover(arr);
		HeapSort(arr);
		print(arr);
		input.close();
	}
	
	private static void print(int[] arr) {
		for (int item : arr)  {
			System.out.print(item + "  ");
		}
	}

	private static void HeapSort(int[] arr) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		if (arr.length == 0) return;
		for (int item : arr) {
			minHeap.add(item);
		}
		for (int i = 0; minHeap.size() > 0; i++, minHeap.poll()) {
			arr[i] = minHeap.peek();
		}
	}

	private static void Remover(int[] arr) {
		Set<Integer> set = new HashSet<>();
		if (arr == null) return;
		
		for (int item : arr) {
			set.add(item);
		}
		arr = null;
		arr = new int[set.size()];

		Iterator<Integer> it = set.iterator();
		int i = 0;
		while (it.hasNext()) {
			arr[i] = it.next();
			i++;
		}
	}
}

