package coreJava;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;

public class EasyArrays {

    static void print(Integer[] arr) {
        for (var item : arr) System.out.print(item + " ");
    }

    static void func(int[] arr) {
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        Integer[] ints = new Integer[arr.length];
        int pointer = -1;
        for (int item : arr) {
            ints[++pointer] = item;
        }
        Arrays.sort(ints, Collections.reverseOrder());

        System.out.println(Arrays.binarySearch(arr, 4));
        // Arrays.copyOfRange(ints, 2, ints.length-1);
        Arrays.fill(arr, 2, arr.length-1, 69);
        Arrays.parallelSort(ints);
        print(ints);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arr = new int[input.nextInt()];
        for (int i=0; i< arr.length; i++) {
            arr[i] = input.nextInt();
        }
        func(arr);

        input.close();
    }

}
