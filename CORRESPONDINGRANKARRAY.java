import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

public class CORRESPONDINGRANKARRAY {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] arr = new int[input.nextInt()];
		
		for (int i = 0; i < arr.length; i++) arr[i] = input.nextInt();
		System.out.println(correspondingarray(arr));
		input.close();
	}

	private static List<Integer> correspondingarray(int[] arr) {
		int[] tmp = new int[arr.length];
		System.arraycopy(arr, 0, tmp, 0, arr.length);
		
		Arrays.sort(tmp);
		int[] order = new int[max(arr)];
		for (int i = 0; i < tmp.length; i++) {
			arr[i] = i;
		}
		List<Integer> __final__ = new LinkedList<>();
		for (int i = 0; i < arr.length; i++) {
			__final__.add(tmp[arr[i]]);
		}
		return __final__;
	}
	
	private static int max(int[] arr) {
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			max = Integer.max(max, arr[i]);
		}		
		return max;
	}

}
