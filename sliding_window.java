public class sliding_window {

    public static int low(int[] arr) {
        int ans = 0;
        int min = Integer.MIN_VALUE;

        for (int i = 0; i < 3; i++) {
            ans += arr[i];
        }
        min = Integer.max(min, ans);

        for (int i = 3; i < arr.length; i++) {
            ans += arr[i] - arr[i - 3];
            min = Integer.max(min, ans);
        }
        return min;
    }
    

    public static void main(String[] args) {
        int[] arr = { 7, 8, 0, 1, -3, 4 };
        System.out.println(low(arr));
    }


}
