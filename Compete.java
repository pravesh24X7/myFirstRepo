import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Compete {

    static boolean Util(int k, int n) {
        for (int i = k; i <= n; i++) {
        }
        return true;
    }


    static int procedure(int n) {
        int maxVal = Integer.MIN_VALUE;
        int tmp = 0;

        for (int i = 1; i <= n; i++) {
            tmp = n & (n - i);

        }

        return maxVal;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        System.out.println(procedure(n));

        br.close();
    }
    

}
