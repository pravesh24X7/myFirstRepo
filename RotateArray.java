import java.util.Collections;
import java.util.Arrays;
import java.util.Scanner;

public class RotateArray {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arr = new int[input.nextInt()];

        for (int i = 0; i < arr.length; i++)
            arr[i] = input.nextInt();
        ROTATEARRAY(arr, input.nextInt());
        print(arr);

        input.close();
    }


    static void print(int[] arr) {
        for (int a : arr) System.out.print(a + "  ");
    }

    
    static void ROTATEARRAY(int[] arr, int size) {
        Collections.rotate(Arrays.asList(arr), size);
        print(arr);
    }

}
