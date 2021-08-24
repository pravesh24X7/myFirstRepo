package recursion;

import java.util.Scanner;

public class MakeStringPalindrome {

    static int operations(String a, int lcs_len) {
        return a.length() - lcs_len;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String a = input.nextLine();
        String revStr = new StringBuffer(a).reverse().toString();

        arr = new int[a.length()+1][a.length()+1];

        int lcs_len = LCS(a, revStr, a.length(), revStr.length());
        System.out.println(lcs_len);
        System.out.println(operations(a, lcs_len));

        input.close();
    }

    static int[][] arr;

    private static int LCS(String str1, String str2, int l1, int l2) {
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
        int j= str2.length();

        while (i > 0 && j > 0) {
            if (str1.charAt(i-1) == str2.charAt(j-1)) {
                lcs[index-1] = str1.charAt(i-1);
                i--; j--; index--;
            } else if (arr[i-1][j] > arr[i][j-1]) i--; else j--;
        }

        System.out.println(new String(lcs));
        return arr[str1.length()][str2.length()];
    }

}
