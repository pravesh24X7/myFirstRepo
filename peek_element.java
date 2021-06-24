import java.util.PriorityQueue;

public class peek_element {


    public static int peek(int[] items) {
        PriorityQueue<Integer> max_heap = new PriorityQueue<>();
        for (int item : items) {
            if (max_heap.size() > 1) {
                max_heap.poll();
            }
            max_heap.add(item);
        }
        if (max_heap.size() > 1) {
            max_heap.poll();
        }
        return max_heap.poll();
    }


    public static void main(String[] args) {
        int[] items = { 5, 6, 3, 8 };
        System.out.println(peek(items));        
    }


}
