import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;


public class file9 {

    static boolean validator(String init) {
        char[] arr = new char[256];
        for (char c:init.toCharArray()) {
            arr[c]++;
        }
        for (int i=0; i<arr.length; i++) {
            if (arr[i] > 1) {
                return false;
            }
        }
        return true;
    }

    static String procedure(String init) {
        // if (init.length())
        List<String> list = func(init);
        List<String> newList = new LinkedList<>();
        int len = Integer.MIN_VALUE, replica = 0;
        for (String str:list) {
            if (validator(str)) {
                replica = len;
                len = Math.max(len, str.length());
                if (len != replica) {
                    newList.clear();
                    newList.add(str);
                }
            }
        }
        return newList.toString();
    }

    static List<String> func(String init) {
        List<String> list = new LinkedList<>();
        for (int i=0; i<init.length(); i++) {
            for (int j=i+1; j<=init.length(); j++) {
                list.add(init.substring(i,j));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String test = input.nextLine();
        // String search = input.nextLine();
        System.out.println(procedure(test));

        input.close();
    }

}
