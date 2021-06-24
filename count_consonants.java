import java.util.Scanner;

public class count_consonants {
    private static int get_count(String str) {
        var count = 0;
        for (char c:str.toLowerCase().toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }
        return str.length()-count;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String init_str = input.next();
        System.out.println(get_count(init_str));
        input.close();
    }
}
