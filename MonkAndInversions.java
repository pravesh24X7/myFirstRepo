package coreJava;
import java.io.*;
import java.util.Arrays;

public class MonkAndInversions {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int tc = Integer.parseInt(input.readLine());
        while (tc > 0) {
            int n = Integer.parseInt(input.readLine());
            solve(n);
            tc--;
        }
        input.close();
    }

    private static void solve(int n) throws IOException {
        int[][] arr = new int[n][n];
        for (int[] od : arr) {
            for (int i=0; i<od.length; i++) {
                od[i] = Integer.parseInt(input.readLine());
            }
        }
        pleaseSort(arr);
        print(arr);
    }

    private static void print(int[][] arr) {
        for (int[] od : arr) {
            for (int i : od) {
                System.out.print(i +  " ");
            }
            System.out.println();
        }
    }

    private static void pleaseSort(int[][] arr) {
        for (int[] od : arr) {
            Arrays.sort(od);
        }
        for (int i=0; i<arr.length; i++) {
            for (int j=1; j<arr.length; j++) {
                if (arr[j-1][i] > arr[j][i]) {
                    int tmp = arr[j-1][i];
                    arr[j-1][i] = arr[j][i];
                    arr[j][i] = tmp;
                }
            }
        }
    }

}
