import java.util.PriorityQueue;
import java.util.Scanner;

public class frequency_sort {

    public static void sort(int[] arr) {
        PriorityQueue<Integer> min_heap = new PriorityQueue<>();

        for (var i = 0; i < arr.length; i++) {
            min_heap.add(arr[i]);
        }
        
        for (int i = 0; min_heap.size() > 0; i++, min_heap.poll()) {
            arr[i] = min_heap.peek();
        }
    }

    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];

        for (var idx = 0; idx < n; idx++)
            arr[idx] = input.nextInt();
        
        print_array(arr);
        sort(arr);
        input.close();
    }

    private static void print_array(int[] arr) {
        for (var item : arr)
            System.out.print(item + " ");
    }
}
