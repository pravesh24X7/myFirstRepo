package coreJava;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class BinaryNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        func(number);

        input.close();
    }

    private static void func(int number) {
        String binaryPresentation = Integer.toBinaryString(number);
        List<String> list = new ArrayList<>();
        for (int i=0; i<binaryPresentation.length(); i++) {
            list.add(binaryPresentation.substring(i, binaryPresentation.length()-1));
        }
        for (int i=0; i<list.size(); i++) {
            if (choper(list.get(i))) {
            }
        }
    }

    private static boolean choper(String string) {
        for (int i=0; i<string.toCharArray().length; i++) {
            int num = 0;
            if (i+1 <= string.length()-1) {
                int number = Character.getNumericValue(string.charAt(i));
                int number1 = Character.getNumericValue(string.charAt(i+1));
                num = num * 10 + number;
                num = num * 10 + number1;
                if (num == 11) {
                    return true;
                }
            }
        }
        return false;
    }

}
