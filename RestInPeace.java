package coreJava;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;


public class RestInPeace {
    static ArrayList<String> list;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        list = new ArrayList<>();
        int tc = input.nextInt();

        while (tc-- > 0) {
            int number = input.nextInt();
            list.add(solution(number));
        }
        for(String string : list) System.out.println(string);

        input.close();
    }

    private static String solution(int number) {
        ArrayList<Integer> arr = new ArrayList<>();
        if (number % 21 == 0) return "The streak is broken!";
        while (number > 0) {
            arr.add(number % 10);
            number /= 10;
        }
        Collections.reverse(arr);
        for (int i=0; i<arr.size(); i++) {
            if (i + 1 < arr.size() && arr.get(i) == 2 && arr.get(i + 1) == 1) return "The streak is broken!";
        }
        return "The streak lives still in our heart!";
    }

}
