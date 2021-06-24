import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Iterator;

public class TEXTREVERSAL  {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String line = input.nextLine();
	
//		System.out.println(textreversal(line));
		input.close();
	}
	
	static void textreversal(String line) {
		List<String> arr = new LinkedList<>();
		Stack<String> s = new Stack<>();
	
		String global = "";
		for (char c : line.toCharArray()) {
			if (c == ' ') {
				arr.add(global);
				global = "";
			}
			global += c;
		}

		Iterator<String> it = arr.iterator();
		while (it.hasNext()) {
			s.add(it.next());
		}
	//	arr.clear();
		while (s.size() > 0) {
			System.out.println(s.pop());
		}
	}
}

