import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class QuadraticHeaps {

    public static int Quadratic(int a, int b, int c, int x) {
        return (int) (a * (Math.pow(x, 2)) + (b * x) + c);
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();

        result(arr, a, b, c);
        input.close();
    }
    

    public static void result(int[] arr, int a, int b, int c) {
        List<Integer> ans = new LinkedList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int item : arr) {
            minHeap.add(Quadratic(a, b, c, item));
        }
        while (minHeap.isEmpty()) {
            ans.add(minHeap.poll());
        }
        System.out.println(ans);
    }


}
