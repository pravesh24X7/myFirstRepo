import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;


public class print_nodes_lesstThanX {
    
    public static void main(String[] args) {
        PriorityQueue<Integer> min_heap = new PriorityQueue<>();
        int[] items_of_min_heap = { 2, 3, 15, 5, 4, 45, 80, 6, 150, 77, 120 };
        
        for (var item : items_of_min_heap)
            min_heap.add(item);
        Scanner input = new Scanner(System.in);
        int key_value = input.nextInt();
        System.out.println(generate_ans_list(min_heap, key_value));
        
        input.close();
    }

    private static List<Integer> generate_ans_list(PriorityQueue<Integer> min_heap, int key_value) {
        List<Integer> ans = new ArrayList<>();        
        for (var item : min_heap) {
            if (item < key_value) {
                ans.add(item);
            }
        }
        return ans;
    }
}
