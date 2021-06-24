import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;

// Java Code to get the Window Sum of the given array.

public class file6 {

  static void getWindowSum(int[] arr, int k, List<Integer> list) {
    int sumOfWindow = 0;
    int i;

    for (i=0; i<k; i++) {
      sumOfWindow += arr[i];
    }
    list.add(sumOfWindow);
    // sumOfWindow = 0;

    for (int j=i; j<arr.length; j++) {
      sumOfWindow += arr[j];
      sumOfWindow -= arr[j-k];
      list.add(sumOfWindow);
    }

  }


  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int[] arr = new int[input.nextInt()];

    for (int i=0; i<arr.length; i++) {
      arr[i] = input.nextInt();
    }

    List<Integer> list = new LinkedList<>();
    getWindowSum(arr, input.nextInt(), list);

    System.out.println(list);

    input.close();
  }

}
