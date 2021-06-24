import java.util.Scanner;
import java.util.Arrays;

public class dp {

    static int[] dp;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        dp = new int[100000];
        Arrays.fill(dp, -1);

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(dp[n]);

        input.close();
    }


}
