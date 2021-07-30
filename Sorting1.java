package coreJava;
import java.util.Arrays;
import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Collections;
import java.util.Queue;

public class Sorting1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arr = new int[input.nextInt()];
        fillUp(arr);
        sortUsingINS(arr);
        System.out.println(Arrays.toString(arr));
        fillUp(arr);
        sortUsingHS(true, arr);
        System.out.println(Arrays.toString(arr));
        sortUsingHS(false, arr);
        System.out.println(Arrays.toString(arr));


        input.close();
    }

    private static void sortUsingHS(boolean thinking, int... arr) {
        if (thinking) {
            Queue<Integer> minHeap = new PriorityQueue<>();
            for (var item : arr) minHeap.add(item);
            int arrayPointer = -1;
            while (minHeap.size() > 0) {
                arr[++arrayPointer] = minHeap.poll();
            }
            return;
        }
        Queue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (var item : arr) minHeap.add(item);
        int arrayPointer = -1;
        while (minHeap.size() > 0) {
            arr[++arrayPointer] = minHeap.poll();
        }
    }

    private static void fillUp(int... arr) {
        for (int i=0; i<arr.length; i++) arr[i] = 9-i;
    }

    private static void sortUsingINS(int... arr) {
        for(int i=1; i<arr.length; i++) {
            int j = i;
            while (j>0 && arr[j-1] > arr[j]) {
                swapBothOfThem(j-1, j, arr);
                j--;
            }
        }
    }

    private static void swapBothOfThem(int i, int j, int... arr) {
        var tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
