import java.util.Scanner;

public class cursed_javaOne {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        var sx = input.nextInt();
        int[] items = new int[sx];

        for (var i=0; i<sx; ++i) items[i] = input.nextInt();
        System.out.println(get_min_recursively(items, Integer.MAX_VALUE, 0));
        input.close();
    }

    private static int get_min_recursively(int[] items, int min_key, int idx) {
        if (idx < items.length) {
            min_key = Integer.min(min_key, items[idx]);
            idx++;
            return get_min_recursively(items, min_key, idx);
        }
        return min_key;
    }

}