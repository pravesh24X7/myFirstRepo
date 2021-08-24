package recursion;

import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;


public class MatchingSubSequences {

    static boolean LCS(String str1, String str2, int l1, int l2) {
        for (int i=1; i<=l1; i++) {
            for (int j=1; j<=l2; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    arr[i][j] = 1 + arr[i-1][j-1];
                } else {
                    arr[i][j] = Math.max((arr[i-1][j]), (arr[i][j-1]));
                }
            }
        }

        int index = arr[str1.length()][str2.length()];
        char[] lcs = new char[index+1];
        lcs[index] = '\u0000';

        int i = str1.length();
        int j = str2.length();

        while (i > 0 && j > 0) {
            if (str1.charAt(i-1) == str2.charAt(j-1)) {
                lcs[index-1] = str1.charAt(i-1);
                i--; j--; index--;
            } else if (arr[i-1][j] > arr[i][j-1]) i--; else j--;
        }

        return str2.equals(new String(lcs));
    }

    static void func(String a, List<String> string) {
        for (String str : string) {
            arr = new int[a.length()+1][str.length()+1];
            if (LCS(a, str, a.length(), str.length())) Counter++;
        }
    }

    static int Counter;
    static int[][] arr;

    public static void main(String[] args) {
        String a = "dsahjpjauf";
        List<String> string = new LinkedList<>();
        string = Arrays.asList(new String("ahjpjau"), new String("ja"),
                new String("ahbwzgqnuk"),new String("tnmlanowax"));

        func(a, string);
        System.out.println(Counter);

    }

}
