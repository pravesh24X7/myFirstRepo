import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * time Complexity of this Code is O(n * n!)
 * Space Complexity of this is O(n!)
 */


public class string_permutataion {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String init_str = input.next();
        List<String> ans = new ArrayList<>();

        permutataion(init_str, ans);
        System.out.println(ans.size());
        System.out.println(ans);
        input.close();
    }

    private static void permutataion(String init_str, List<String> ans) {
        generator("",init_str, ans);
    }

    private static void generator(String string, String init_str, List<
    String> ans) {
        if (init_str.isEmpty())
            ans.add(string + init_str);
        else {
            for (int i = 0; i < init_str.length(); i++) {
                generator(string+init_str.charAt(i), init_str.substring(0,i)+init_str.substring(i+1, init_str.length()), ans);
            }
        }
    }
}
