import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;

public class file8 {

    static void checkForTargets(int[] arr, List<Integer> list, int target) {
        int t1 = target+1;
        int t2 = target-1;

        int i=0, sum=0;
        for (i=0; i<arr.length; i++) {
            sum += arr[i];
        }

        if (sum == target || sum == t1 || sum == t2) {
            for (int j=i; j>=0; j--) {
                list.add(arr[j]);
            }
            list.add(Integer.MAX_VALUE);
        }

        for (int j=i; j<arr.length; j++) {
            sum += arr[j];
            sum -= arr[j];

            if (sum == target || sum == t1 || sum == t2) {
                for (int k=i; k>=(j-3); k--) {
                    list.add(arr[k]);
                }
                list.add(Integer.MAX_VALUE);
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
        checkForTargets(arr, list, input.nextInt());

        System.out.println(list);

        input.close();
    }
}
