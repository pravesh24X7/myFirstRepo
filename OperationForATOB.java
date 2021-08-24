package recursion;

import java.util.Scanner;

public class OperationForATOB {

    static void operations(String str1, String str2, int lcs_len) {
        InsertionCounter = str2.length() - lcs_len;
        DeletionCounter = str1.length() - lcs_len;

        System.out.println(InsertionCounter + " " + DeletionCounter);
    }

    static int LCS(String str1, String str2, int l1, int l2) {
        for (int i=1; i<=l1; i++) {
            for (int j=1; j<=l2; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    arr[i][j] = 1 + arr[i-1][j-1];
                } else {
                    arr[i][j] = Math.max((arr[i-1][j]), (arr[i][j-1]));
                }
            }
        }

        return arr[str1.length()][str2.length()];
    }

    static int InsertionCounter;
    static int DeletionCounter;
    static int[][] arr;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String a = input.nextLine();
        String b = input.nextLine();

        arr = new int[a.length()+1][b.length()+1];
        int lcs_len = LCS(a, b, a.length(), b.length());
        operations(a, b, lcs_len);

        input.close();
    }

}
