import java.util.PriorityQueue;
import java.util.List;
import java.util.LinkedList;

public class median_of_twoArray {

    public static int median(int[] final_arr) {
        if (final_arr.length / 2 == 0) {
            int idx = final_arr.length / 2;
            return (final_arr[idx] + final_arr[idx - 1]) / 2;
        }
        return final_arr[final_arr.length / 2];
    }
    

    public static void main(String[] args) {
        int[] arr1 = { -5, 3, 6, 12, 15 };
        int[] arr2 = { -12, -10, -6, -3, 4, 10 };

        List<Integer> final_arr = merge(arr1, arr2);
        int[] ans = new int[final_arr.size()];
        int i = 0;
        for (var item : final_arr) {
            ans[i] = item;
            i++;
        }
        System.out.println("Median is :" + median(ans));
    }
    
    public static List<Integer> merge(int[] arr1, int[] arr2) {
        PriorityQueue<Integer> min_heap = new PriorityQueue<>();
        List<Integer> final_arr = new LinkedList<>();
        
        for (int item : arr1) {
            min_heap.add(item);
        }
        for (int item : arr2) {
            min_heap.add(item);
        }
        while (min_heap.isEmpty()) {
            var keep = min_heap.peek();
            final_arr.add(keep);
            min_heap.poll();
        }
        return final_arr;
    }
    

}
