import java.util.Scanner;

public class pali_checker {

    private static boolean get_result(int[] arr, int lb, int ub) {
        if (ub > lb) {
            if (arr[lb] != arr[ub]) return false;
            lb++; ub--;
            return get_result(arr, lb, ub);
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pali_num = input.nextInt();
        int[] arr_of_int = get_arr(pali_num);
        System.out.println(get_result(arr_of_int, 0, arr_of_int.length-1));

        input.close();
    }

    private static int counter(int num) {
        var count = 0;
        while (num > 0) {
            count++;
            num /= 10;
        }
        return count;
    }

    private static int[] get_arr(int pali_num) {
        int[] arr = new int[counter(pali_num)];
        for (var point=0; pali_num > 0; pali_num /= 10, point++) {
            arr[point] = pali_num;
        }
        return arr;
    }
}
