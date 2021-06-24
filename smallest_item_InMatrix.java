import java.util.Collections;
import java.util.PriorityQueue;

public class smallest_item_InMatrix {

    // public static void sort_matrix(int[][] matrix) {
    //     PriorityQueue<Integer> min_heap = new PriorityQueue<>();

    // }


    public static int get_min_fromGrid(int[][] matrix) {
        PriorityQueue<Integer> min_heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix.length; j++) {
                min_heap.add(matrix[i][j]);
                if (min_heap.size() > 1) {
                    min_heap.poll();
                }
            }
        }
        return min_heap.poll();
    }


    public static void print_grid(int[][] matrix) {
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    
    public static void main(String[] args) {
        int[][] matrix = {
            {6, 4, 9},
            {5, 2, 1},
            {7, 8, 0}
        };

        print_grid(matrix);
        System.out.println(get_min_fromGrid(matrix));
    }
}
