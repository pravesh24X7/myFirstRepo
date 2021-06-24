import java.util.Scanner;

public class string_reversal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String init_str = input.next();

        char[] arr_of_str = init_str.toCharArray();
        reverse_given_str(arr_of_str, 0, arr_of_str.length-1);

        System.out.println(new String(arr_of_str));
        input.close();
    }

    private static void swap_arr_items(char[] arr, int l, int r) {
        var tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }

    private static void reverse_given_str(char[] arr_of_str, int left, int right ) {
        if (right > left) {
            swap_arr_items(arr_of_str, left, right);
            left++; right--;
            reverse_given_str(arr_of_str, left, right);
        }
    }
}