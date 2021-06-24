import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Java Code to remove duplicate character from String 
 */

public class func11 {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter String :");
        String str = input.next();

        String new_string = dup_remover(str);
        System.out.println("New String :" + new_string);

        input.close();
    }

    private static String dup_remover(String str) {
        List<Character> ll = new ArrayList<>();
        for (var i=0; i<str.length(); ++i) {
            if (ll.contains(str.charAt(i))) continue;
            ll.add(str.charAt(i));
        }
        return ll.toString();
    }


}
