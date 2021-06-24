import java.util.Scanner;

public class FINDTHESQUAREROOT {
	private static int squareroot(int n) {
		if (n < 2) return n;
		int floor = 0;
		int start  = 1;
		int end = n / 2;

		while (start <= end) {
			int mid = (start + end) / 2;
			long sqrt = mid * mid;
			if (sqrt == n) return mid;
			if (sqrt < n) {
				
				start = mid + 1;
				floor = mid;
			} 
			if (sqrt > n) {
				end = mid - 1;
			
			}
		}
		return floor;

	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int i = input.nextInt();
		
		System.out.println(squareroot(i));
		input.close();
	}
}
