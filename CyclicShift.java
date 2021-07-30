package coreJava;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class CyclicShift {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int tc = Integer.parseInt(input.readLine());
        List<Integer> counts = new ArrayList<>();
        while (tc > 0) {
            counts.add(solve());
            tc--;
        }
        for (int i : counts) {
            System.out.println(i);
        }
        input.close();
    }

    private static int solve() throws IOException {
        int n = Integer.parseInt(input.readLine());
        int k = Integer.parseInt(input.readLine());
        long val = Long.parseLong(input.readLine());

        int decimalOfVal = 0;
        int counter  = 0;

        while (decimalOfVal != k) {
            counter++;
            val = val >> 1;
            decimalOfVal = Integer.parseInt(Long.toBinaryString(val));
        }
        return counter;
    }

}
