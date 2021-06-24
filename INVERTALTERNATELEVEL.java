import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

import java.util.List;


public class INVERTALTERNATELEVEL {
	
	static class Node {
		int item;
		Node left, right;
		Node(int item ) {
			this.item = item;
			left = right = null;
		}
	}	
	
	public static void print(Node node) {
		Queue<Node> que = new LinkedList<>();
		que.add(node);
		
		while (!que.isEmpty()) {
			Node tmp = que.poll();
			System.out.print(tmp.item);
			if (node.left != null) que.add(node.left);
			if (node.right != null) que.add(node.right); 
		}
	}

	static List<Integer> makechanges(Node root) {
		if (root == null || root.right == null && root.left == null) return new LinkedList<>() ;
		Queue<Node> que = new LinkedList<>();
		Stack<Node> stk = new Stack<>();
		List<Integer> ans = new LinkedList<>();

		int pointer = 0;
		while (!que.isEmpty()) {
			Node tmp = que.poll();
			ans.add(tmp.item);
			if (pointer % 2 != 0) {
				if (tmp.left != null) stk.add(tmp.left);
				if (tmp.right != null) stk.add(tmp.right);
			}
			if (tmp.left != null) que.add(tmp.left);
			if (tmp.right != null) que.add(tmp.right);
			pointer++;
		}
		return ans;
	}
		
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.left.left.left = new Node(8);
		root.left.left.right = new Node(9);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(11);
		root.right.left.left = new Node(12);
		root.right.left.right = new Node(13);
		root.right.right.left = new Node(14);
		root.right.right.right = new Node(15);

		print(root);
		System.out.println(makechanges(root));
	}
}	
