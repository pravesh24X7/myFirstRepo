import java.util.PriorityQueue;
import java.util.Collections;


public class smallest_sec_smallest {

    public static void main(String[] args) {
        int[] arr = { 7, 65, 8, 4, 9, 2, 1, 5, 0 };
        int[] ans = get_two_small(arr);
        System.out.println(ans[0] + " " + ans[1]);        
    }

    
    public static int[] get_two_small(int[] arr) {
        PriorityQueue<Integer> min_heap = new PriorityQueue<>(Collections.reverseOrder());
        int[] ans = new int[2];

        for (int idx : arr) {
            if (min_heap.size() > 2) {
                min_heap.poll();
            }
            min_heap.add(idx);
        }
        if (min_heap.size() == 2) {
            ans[0] = min_heap.poll();
            ans[1] = min_heap.poll();
        }

        return ans;
    }


}
