package coreJava;
import java.io.*;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class MonkAndRotation {

    static List<List<Integer>> ans;
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int tc = Integer.parseInt(input.readLine());
        ans = new ArrayList<>();
        while (tc > 0) {
            int n = Integer.parseInt(input.readLine());
            int k = Integer.parseInt(input.readLine());
            ans.add(solve(n, k));
            tc--;
        }
        for (List<Integer> list : ans) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        input.close();
    }

    private static List<Integer> solve(int n, int k) throws IOException {
        List<Integer> arr = new ArrayList<>(n);
        for (int i=0;i<n;i++) arr.add(Integer.parseInt(input.readLine()));
        Collections.rotate(arr, k);
        return arr;
    }

}
