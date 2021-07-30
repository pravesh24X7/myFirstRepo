package recursion;

import java.util.Stack;
import java.util.Scanner;


public class stacks {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Stack<Integer> s = new Stack<>();

		for (int i=0; i<input.nextInt(); i++) {
			s.add(input.nextInt());
		}

		func(s);
		System.out.println(s);
	
		input.close();
	}

	static void func(Stack<Integer> s) {
		if (s.size() == 1 || s.size() == 0) {
			return;
		}

		int last = s.peek();
		s.pop();
	
		func(s);
		insert(s, last);
	}


	static void insert(Stack<Integer> s, int item) {
		if (s.size() == 0 || s.peek() <= item) {
			s.push(item);
			return;
		}

		int last_idx = s.peek();
		s.pop();
		insert(s, item);

		s.push(last_idx);
	}


}
