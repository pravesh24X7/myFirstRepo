package coreJava;
import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class MinimumAndXorOr {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static List<Integer> ans;

    public static void main(String[] args) throws IOException {
        ans = new ArrayList<>();
        int tc = Integer.parseInt(input.readLine().trim());
        while (tc -- > 0) {
            String[] inputLine = input.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            inputLine = input.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i=0; i<n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            ans.add(solve(arr));
        }
        for (Integer i : ans) {
            System.out.println(i);
        }
        input.close();
    }

    private static int solve(int[] arr) {
        int pointerMin = Integer.MAX_VALUE;
        for (int i=0; i<= arr.length-1; i++) {
            int presentMinPointer;
            if (i+1 < arr.length) {
                int andOperation = arr[i] & arr[i+1];
                int orOperation = arr[i] | arr[i+1];
                presentMinPointer = andOperation ^ orOperation;
                pointerMin = Integer.min(presentMinPointer, pointerMin);
            }
        }
        return pointerMin;
    }

}
