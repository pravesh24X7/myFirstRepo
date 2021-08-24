package recursion;

import java.util.Scanner;

public class LongestRepeatingSubSequence {

    static int func(String s) {
        char[] arr = new char[128];
        for (char c : s.toCharArray()) {
            arr[c]++;
        }
        StringBuffer sb = new StringBuffer();
        for (int i=0; i<arr.length; i++) {
            if (arr[i] > 1) {
                sb.append((char) i);
            }
        }
        System.out.println(sb);
        return sb.length();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String a = input.nextLine();
        System.out.println(func(a));
        input.close();
    }

}
