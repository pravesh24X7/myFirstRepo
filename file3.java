import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class file3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] arr = new int[input.nextInt()];
		
		for (int i=0; i<arr.length; i++) {
			arr[i] = input.nextInt();
		}

		System.out.println(subArrayWithSum(input.nextInt(), arr));

		input.close();
	}

	static boolean subArrayWithSum(int sum, int... arr) {
		boolean flag = false;
		List<Integer> tmp = new ArrayList<>();
		
		for (int i=0; i<arr.length; i++) {
			tmp.add(arr[i]);
			int listSum = getListSum(tmp);
			while (listSum > sum) {
				tmp.remove(0);
				listSum = getListSum(tmp);
			}
			listSum = getListSum(tmp);
			if (listSum == sum) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	static int getListSum(List<Integer> tmp) {
		int sum = 0;
		for (Integer a : tmp) {
			sum += a;
		}
		return sum;
	}
	
}
