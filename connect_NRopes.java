//import java.util.ArrayList;
import java.util.Scanner;
import java.util.PriorityQueue;

public class connect_NRopes {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for (var i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        System.out.println("Optimal Cost of Addition of ropes is :" + get_oprimalCost(arr));

        input.close();
    }
    

    public static int get_oprimalCost(int[] arr) {
        PriorityQueue<Integer> min_heap = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            min_heap.add(arr[i]);
        }
        int optimal = 0;
        while (min_heap.size() > 1) {
            var first_min = min_heap.poll();
            var sec_min = min_heap.poll();
            var total = first_min + sec_min;
            optimal += total;
            min_heap.add(total);
        }
        return optimal;
    }


}
