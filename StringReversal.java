package coreJava;

import java.util.Scanner;

public class StringReversal
{

    public static void main(String[] args)
    {

        Scanner input = new Scanner(System.in);
        String string = input.nextLine();

        char[] newString = string.toCharArray();
        solution(newString);
        System.out.println(new String(newString));
        System.out.println(solutions(string));

        input.close();

    }

    private static boolean solutions(String string)
    {
        if (string.length() == 0 || string.length() == 1)
        {
            return true;
        }

        if (string.charAt(0) != string.charAt(string.length()-1))
        {
            return false;
        }

        return solutions(string.substring(1, string.length()-1));

    }

    private static void solution(char[] arr)
    {
        if (arr.length == 1 || arr.length == 0)
        {
            return;
        }

        var tmp = arr[0];
        arr[0] = arr[arr.length-1];
        arr[arr.length-1] = tmp;
        String string  = new String(arr).substring(1,arr.length-1);
        solution(string.toCharArray());

    }

}
