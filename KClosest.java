import java.util.List;
import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class KClosest {

    public static List<Integer> get_KClosest(int[] arr, int x, int k) {
        PriorityQueue<HashMap<Integer, Integer>> max_heap = new PriorityQueue<>(Collections.reverseOrder());
        //ArrayList<Integer> tmp_list = new ArrayList<>();
        for (int i=0; i<arr.length; i++) {
            max_heap.add(map.put(Math.abs(arr[i] - x), arr[i]));
            //tmp_list.add(arr[i]);
            if (max_heap.size() > k) {
                //tmp_list.remove(arr[i]);
                max_heap.poll();
            }
        }
        ArrayList<Integer> rtn_list = new ArrayList<>();
        while (max_heap.size() > 0) {
            rtn_list.addAll(max_heap.element().values());
        }
        return rtn_list;
    } 
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sx = input.nextInt();
        int[] arr = new int[sx];
        
        for (int i=0; i<sx; ++i) arr[i] = input.nextInt();
        int x = input.nextInt();
        int k = input.nextInt();

        System.out.println(get_KClosest(arr, x, k));
        input.close();
    }
}
