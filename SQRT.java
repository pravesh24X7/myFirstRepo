import java.util.Scanner;

public class SQRT {

    private static int Result(int n) {
        int ans = 0;
        for (int i = 2; i <= (n / 4); i++) {
            if ((int) Math.pow(i, 2) == n) {
                ans = i;
                break;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println(Result(input.nextInt()));

        input.close();
    }


}
