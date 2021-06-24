import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Java Code to remove duplicates from given array
 */

public class func5 {
    
    public static void main(String[] args) {
        System.out.println("Enter N");
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();

        int [] arr = new int[N];
        for (var i=0; i<N; ++i) arr[i] = input.nextInt();
        Set<Integer> set = new HashSet<>();
        modifiedArray(arr, set);

        List<Integer> ll = new ArrayList<>(set);
        Collections.sort(ll);
        System.out.println(ll);

        input.close();
    }

    private static void modifiedArray(int[] arr, Set<Integer> set) {
        if (arr.length == 0 || arr.length == 1) {
            set.add(arr[0]);
            return;
        }
        for (var a : arr) set.add(a);
    }
}
