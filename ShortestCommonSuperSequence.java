package recursion;

import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;


public class ShortestCommonSuperSequence {

    static void SCSS(String str1, String str2) {
        List<Character> list1 = new LinkedList<>(), list2 = new LinkedList<>();
        for (Character c : str1.toCharArray()) {
            list1.add(c);
        }

        for (Character c : str2.toCharArray()) {
            list1.add(c);
        }

        for (Character c : lcs_str.toCharArray()) {
            list2.add(c);
        }

        for (Character c : list1) {
            if (list2.contains(c)) {
                list1.remove(list1.lastIndexOf(c));
            }
        }

        System.out.println(list1);
    }

    static int[][] arr;
    static String lcs_str;

    static  int LCS(String str1, String str2, int l1, int l2) {
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

        lcs_str = new String(lcs);
        return arr[str1.length()][str2.length()];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String str1 = input.nextLine();
        String str2 = input.nextLine();

        arr = new int[str1.length()+1][str2.length()+1];

        int lcs_len = LCS(str1, str2, str1.length(), str2.length());
        int len = (str1.length() + str2.length()) - lcs_len;
        System.out.println(len);
        SCSS(str1, str2);

        input.close();
    }

}
