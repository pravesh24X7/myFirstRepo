import java.util.*;

/**
 * Java code to arrange the given number so that they will form the biggest number from that number  
 */

public class func8 {

    // public static int getNum(int [] arr){
    //     for (int i=0; i<arr.length; ++i) {
    //         int bit = arr[i];
    //     }
    // }
    

    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        String num = input.next();

        char [] arr = num.toCharArray();
        Arrays.sort(arr);
        num = new String(arr);
        num = new StringBuilder(num).reverse().toString();
        System.out.println(num);

        input.close();
    }

}
