import java.util.Stack;
import java.util.Scanner;

public class INFIXTOPOSTFIX {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String infix = input.next();
		
		System.out.println(postfixExp(infix));
		input.close();
	}
	
	private static String postfixExp(String infix) {
		Stack<Character> stk = new Stack<>();
		String postfix = "";
	
		for (var c : infix.toCharArray()) {
			if (c == '(') {
				stk.add(c);
			}
			if (c == ')') {
				while (stk.peek() != '(') {
					postfix += stk.pop();
				}
				stk.pop();
			}
			else if (isOperand(c)) {
				postfix += c;
			}
			else {
				while (!stk.isEmpty() && prec(c) >= prec(stk.peek())) {
					postfix += stk.pop();
				}
				stk.add(c);
			}
		}
		while (!stk.isEmpty()) {
			postfix += stk.pop();
		}
		return postfix;
	}
		
	private static boolean isOperand(char c) {
		return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c <= '0' && c <= '9');
	}
	
	private static int prec(char c) {
		if (c == 'x' || c == '/') return 3;
		if (c == '+' || c == '-') return 4;
		if (c == '&') return 8;
		if (c == '^') return 9;
		if (c == '|') return 10;
		return Integer.MAX_VALUE;
	}
}

