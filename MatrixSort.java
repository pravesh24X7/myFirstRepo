package coreJava;
import java.io.*;
import java.util.Arrays;


public class MatrixSort {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(args[0]);
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(input.readLine());
            }
        }

//        String[] inputValues = input.readLine().trim().split( " ");
//        for (int i=0; i<n; i++) {
//            for (int j=0; j<n; j++) {
//                arr[i][j] = Integer.parseInt(inputValues[j]);
//            }
//            int k = 0;
//            while (k++ < n) {
//                inputValues = input.readLine().trim().split(" ");
//            }

        sortMatrix(arr);
        print(arr);
        System.out.println(searchInMatrix(arr, 3));
        input.close();
    }

    private static String searchInMatrix(int[][] arr, int ele) {
        int mid;
        for (int i=0; i< arr.length; i++) {
            int low = 0;
            int high = arr[i].length-1;
            while (low <= high) {
                mid = low + (high - low)/2;
                if (arr[i][mid] == ele) return i + " " + mid;
                else if (arr[i][mid] > ele) high = mid-1;
                else low = mid+1;
            }
        }
        return " ";
    }

    private static void sortMatrix(int[][] arr) {
        for (int[] od : arr) {
            Arrays.sort(od);
        }
        for (int i= arr.length-1; i>=0 ;i--) {
            for (int j=arr.length-1; j>=0; j--) {
                if (i-1 >=0 && arr[j][i-1] > arr[j][i]) {
                    int tmp = arr[j][i-1];
                    arr[j][i-1] = arr[j][i];
                    arr[j][i] = tmp;
                }
            }
        }
    }

    private static void print(int[][] arr) {
        for (int[] od : arr) {
            for (int element : od) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

}