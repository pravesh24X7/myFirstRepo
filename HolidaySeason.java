package coreJava;

public class HolidaySeason {
    public static void main(String[] args) {
        String str = "ababa";
        System.out.println(solution(str.toCharArray()));
    }

    private static int solution(char[] arr) {
        int count = 0;
        for (int i=0; ;) {
            if (i+4 < arr.length && arr[i] == arr[i+2] && arr[i+1] == arr[i+3]) count++;else break;
        }
        for (int i=1; i< arr.length;) {
            if (i+4 < arr.length && arr[i] == arr[i+2] && arr[i+1] == arr[i+3]) count++;else i++;
        }
        return count;
    }

}
