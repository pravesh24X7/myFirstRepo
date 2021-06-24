import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Java Code to get the median of given array
 * here we're doing using Inbuilt List 
 */

public class func6 {
    
    public static void main(String[] args) {
        List<Integer> ll = new ArrayList<>(), ll2 = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int n = input.nextInt();

        for (var i=0; i < N; i++) ll.add(input.nextInt());
        for (var i=0; i < n; ++i) ll2.add(input.nextInt());

        int Idx1 = ll.size()/2;
        int Idx2 = ll2.size()/2;

        List<Integer> result = new ArrayList<>(ll);
        result.addAll(ll2);
        Collections.sort(result);

        System.out.println((double)(ll.get(Idx1) + ll2.get(Idx2)) / 2);
        System.out.println(result);

        input.close();
    }
}
