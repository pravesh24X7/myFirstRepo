import java.util.LinkedList;

public class LONGESTCOMMONSUBSEQUENCE {

    static LinkedList<Character> x;
    static LinkedList<Character> y;


    public static void main(String[] args) {
        String first = "prince";
        String sec = "priya";

        //        List<Character> x = new LinkedList<>(), y = new LinkedList<>();
        x = new LinkedList<>();
        y = new LinkedList<>();
        for (var c : first.toCharArray()) {
            x.add(c);
        }
        for (var c : sec.toCharArray()) {
            y.add(c);
        }

        System.out.println(LongestCommonSubSequence(x.size(), y.size()));
    }


    private static int LongestCommonSubSequence(int a, int b) {
        if (a == 0 && b == 0)
            return 0;
        if (a == 0 || b == 0)
            return 0;
        if (x.get(a - 1) == y.get(b - 1)) {
            return 1 + LongestCommonSubSequence(a - 1, b - 1);
        }
        return Integer.max(LongestCommonSubSequence(a - 1, b), LongestCommonSubSequence(a, b - 1));
    }

    
}
