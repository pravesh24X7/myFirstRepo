package coreJava;
import java.util.Scanner;


public class RegularExpressionMatching {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String string = input.nextLine();
        String pattern = input.nextLine();

        System.out.println(isMatch(string, pattern));

        input.close();
    }

    /**
     *
     *         if (pattern.isEmpty()) return string.isEmpty();
     *         boolean firstMatch = (!string.isEmpty() &&
     *              pattern.charAt(0) == string.charAt(0) || pattern.charAt(0) == '.');
     *
     *         if (pattern.length() >= 2 && pattern.charAt(1) == '*')
     *              return solution(string, pattern.substring(2)) ||
     *                  firstMatch && solution(string.substring(1), pattern);
     *         else return firstMatch && solution(string.substring(1), pattern.substring(1));
     *
     **/

    private static boolean isMatch(String text, String pattern) {

        if (pattern.isEmpty()) return text.isEmpty();
        boolean first_match = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            return (isMatch(text, pattern.substring(2)) ||
                    (first_match && isMatch(text.substring(1), pattern)));
        } else {
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }

}
