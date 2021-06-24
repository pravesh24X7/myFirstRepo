import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;


public class file1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] arr = new int[Integer.parseInt(args[0])];
		for (int i=0; i<arr.length; i++) {
			arr[i] = input.nextInt();
		}

		func(arr);
		print(arr);

		input.close();
	}

	public static void print(int... arr) {
		for (int a:arr) System.out.print(a + " " );
	}

	public static void func(int... arr) {
		List<Integer> negative = new LinkedList<>();
		List<Integer> positive = new LinkedList<>();

		for(int a:arr) if (a < 0) negative.add(a); else positive.add(a);
		int[] newArray = new int[arr.length];
		int i = 0;
		for(i=0; i<negative.size(); i++) newArray[i] = negative.remove(i);
		for(; i<positive.size(); i++) newArray[i] = positive.remove(i);

		System.arraycopy(newArray, 0, arr, 0, newArray.length-1);
	}

}


			

