import java.util.Scanner;

public class reversed_squared_sum {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] arr = new int[input.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = input.nextInt();
        }

        rev(arr, 0, arr.length - 1);
        System.out.println(required_sum(arr));
        input.close();
    }

    public static int required_sum(int[] arr) {
        int ans = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            if (i % 2 == 0) {
                int t1 = (int) Math.pow(arr[i], 2);
                int t2 = (int) Math.pow(arr[i + 1], 2);
                ans = t1 + t2;
            } else {
                int t1 = (int) Math.pow(arr[i], 2);
                int t2 = (int) Math.pow(arr[i + 1], 2);
                ans = t1 - t2;
            }
        }
        return ans;
    }


    public static void swap(int[] arr, int i, int j) {
        var tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public static void rev(int[] arr, int left, int right) {
        if (left < right) {
            swap(arr, left, right);
            rev(arr, ++left, --right);
        }
    }


}
