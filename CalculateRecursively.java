package coreJava;
import java.util.Scanner;

public class CalculateRecursively {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] tmp = new int[input.nextInt()];
        for (int i=0; i<tmp.length; i++) tmp[i] = input.nextInt();
        System.out.println(recursiveAddition(tmp.length-1, tmp));
        System.out.println(recursiveFactorial(5));
        System.out.println(recursiveFibonacci(8));
        System.out.println(recursiveProduct(tmp.length-1, tmp));

        String string = input.nextLine();
        System.out.println(recursivePalindromeCheck(string));
        System.out.println(recursiveReversal(string.toCharArray()));

        input.close();
    }

    private static String recursiveReversal(char[] string) {
        if (string.length == 1 || string.length == 0) return new String(string);
        var tmp = string[0];
        string[0] = string[string.length-1];
        string[string.length-1] = tmp;
        return recursiveReversal(new String(string).substring(1, string.length-1).toCharArray());
    }

    private static boolean recursivePalindromeCheck(String string) {
        if (string.length() == 1 || string.length() == 0) return true;
        if (string.charAt(0) != string.charAt(string.length()-1)) return false;
        return recursivePalindromeCheck(string.substring(1,string.length()-1));
    }

    private static long recursiveProduct(int pointer, int... arr) {
        if (pointer == 0) return arr[pointer];
        return arr[pointer] * recursiveProduct(pointer-1, arr);
    }

    private static int recursiveFibonacci(int number) {
        if (number == 0) return 0;else if (number == 1) return 1;
        return recursiveFibonacci(number-1) + recursiveFibonacci(number-2);
    }

    private static int recursiveFactorial(int number) {
        if (number < 0) return Integer.MIN_VALUE;
        if (number == 0 || number == 1) return 1;
        return number * recursiveFactorial(number-1);
    }

    private static int recursiveAddition(int pointer, int... arr) {
        if (pointer == 0) return arr[pointer];
        return arr[pointer] + recursiveAddition(pointer - 1, arr);
    }

}
