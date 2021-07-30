import java.util.Scanner;

class OneToN {

    public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	int tc = input.nextInt();

	while (tc-- > 0) {
	    solve(input.nextInt());
	}

	input.close();
    }

    static void solve(int n) {
	if (n == 0 || n == 1) {
	    System.out.println(n);
	    return;
	}

	System.out.println(n--);
	solve(n);
    }

}
