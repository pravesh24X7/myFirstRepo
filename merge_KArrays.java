import java.util.*;

public class merge_KArrays {

    static Scanner input = new Scanner(System.in);


    public static int[] merge_KSortedArrays(int[] arr1, int[] arr2) {
        PriorityQueue<Integer> min_heap = new PriorityQueue<>();

        for (var idx : arr1) {
            min_heap.add(idx);
        }
        for (var idx : arr2) {
            min_heap.add(idx);
        }

        int[] final_array = new int[min_heap.size()];
        for (int i = 0; min_heap.size() > 0; i++, min_heap.poll()) {
            final_array[i] = min_heap.peek();
        }
        return final_array;
    }
    

    public static void print_array(int[] arr) {
        for (var idx : arr) {
            System.out.print(idx + " ");
        }
    }



    public static void input_array(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = input.nextInt();
        }
    }

    
    public static void main(String[] args) {
        int _var = input.nextInt();
        int[] arr = new int[_var];
        input_array(arr);

        _var = input.nextInt();
        int[] new_arr = new int[_var];
        input_array(new_arr);

        int[] final_array = merge_KSortedArrays(arr, new_arr);
        print_array(final_array);
        input.close();
    }

    
}
