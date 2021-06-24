import java.util.Scanner;

/**
 * Java Code to perform:
 * Writea	Code	to	check	whether	one	string	is	a	rotation	of	another	
 */

public class func12 {

    // get_result function 
    public static boolean get_result(String new_str, String str) {
        char [] arr = new_str.toCharArray();
        for (int i=0; i<new_str.length(); i++) {
            var tmp = arr[i];
            for (int j=0; j<new_str.length()-1; j++) {
                arr[j] = arr[j+1];
            }
            arr[new_str.length()-1] = tmp;
            if (str.equals(new String(arr))) {
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter String :");
        String new_str = input.next();
        String str = input.next();

        System.out.println(get_result(new_str, str));
        System.out.println(new_str.equals(str));

        input.close();      
    }

}
