import java.util.*;

/**
 * Java code to find the K largest element from array
 */

public class func7 {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        var N = input.nextInt();

        int [] arr = new int[N];
        for (var i=0; i < N; ++i) arr[i] = input.nextInt();
        func7 fc = new func7();
        fc.printArray(arr);

        Arrays.sort(arr);
        System.out.println("Enter value for K :");
        int K = input.nextInt();
        for (var k = (arr.length - K); k < arr.length; ++k) System.out.print(arr[k] + " ");

        input.close();
    }

    private void printArray(int[] arr) {
        for (var i : arr) System.out.print(i + " ");
    }

}
