import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;


public class file7 {

    static int getListSum(List<Integer> list) {
        int sum = 0;
        for (int item : list) {
            sum += item;
        }
        return sum;
    }


    static void subArrayWithGivenSum(int sum, int[] arr, List<Integer> list) {
        int listSum = 0;
        for (int i=0; i<arr.length; i++) {
            list.add(arr[i]);
            listSum = getListSum(list);
            while (listSum > sum) {
                list.remove(0);
                listSum = getListSum(list);
            }
            listSum = getListSum(list);
            if (listSum == sum) {
                System.out.println("procedure Completed");
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arr = new int[input.nextInt()];

        for (int i=0; i<arr.length; i++) {
            arr[i] = input.nextInt();
        }

        List<Integer> list = new LinkedList<>();
        subArrayWithGivenSum(input.nextInt(), arr, list);

        System.out.println(list);

        input.close();
    }
}
