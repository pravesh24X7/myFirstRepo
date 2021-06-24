import java.util.Scanner;

public class bit_masking1 {


    public static void print(char[] arr) {
        for (var item : arr) {
            System.out.print(item);
        }
    }
    

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String bits = Integer.toBinaryString(input.nextInt());

        char[] bits_arr = bits.toCharArray();
        print(bits_arr);

//        System.out.println(modified_bit(bits_arr, input.nextInt()));

        input.close();
    }


}
