package coreJava;

import java.util.Scanner;

public class SubSequence {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String string1 = input.nextLine();
        String string2 = input.nextLine();

        System.out.println(solution(string1, string2));

        input.close();
    }

    private static boolean solution(String string1, String string2) {
        if (string1 == null && string2 == null) return true;
        if (string1 == null || string2 == null) return false;
        if (string1.charAt(string1.length()-1) == string2.charAt(string2.length()-1)) solution(string1.substring(0,string1.length()-1), string2.substring(0, string2.length()-1));
        return solution(string1.substring(0, string1.length()-1), string2) || solution(string1, string2.substring(0, string2.length()-1));
    }

}
