import java.util.Arrays;
import java.util.Scanner;

public class get_substring {
    private static void print_permut(String str) {
        char[] arr_of_char = str.toCharArray();
        Arrays.sort(arr_of_char);
        premut_combo(new String(arr_of_char), str.length(), -1, "");
    }

    // Java code to print the permutation of given String using recursion 
    private static void premut_combo(String str, int n, int idx, String curr) {
        if (n == idx) return;
        System.out.println(curr);
        for (var i=idx+1;i<n; i++) {
            curr += str.charAt(i);
            premut_combo(str, n, i, curr);
            curr = curr.substring(0, curr.length()-1);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String init_str = input.next();

        print_permut(init_str);
        input.close();
    }
}