import java.util.Scanner;


public class KeyPresence {
   
    public static void main(String[] args) {
sndfkljhasldhfasdklf
        Scanner input = new Scanner(System.in);
        int[] arr = new int[input.nextInt()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = input.nextInt();
        }

        System.out.println(KeyMapper(arr, input.nextInt(), input.nextInt()));

        input.close();
    }


    static boolean Util(int[] arr, int i, int j, int item) {
        java.util.Queue<Integer> q = new java.util.ArrayDeque<>();
        for (int pointer = i; pointer < j && pointer < arr.length; pointer++) {
            q.add(arr[pointer]);
        }
        if (!q.contains(item))
            return false;
        return true;
    }


    static boolean KeyMapper(int[] arr, int size, int key) {
        if (arr.length == 0) return false;
        for (int i = 0; i < arr.length; i += size) {
            if (!Util(arr, i, size, key)) {
                return false;
            }
        }
        return true;
    }

}
