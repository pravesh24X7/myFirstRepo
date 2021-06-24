import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.ArrayDeque;


public class BSTTOMINHEAP {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] keys = new int[input.nextInt()];
		
		for (int i = 0; i < keys.length; i++) {
			keys[i] = input.nextInt();
		}
		Node root = null;
		for (int key : keys) {
			root = additem(root, key);
		}
		
		printlevelorder(root);
		makeheap(root);
		input.close();
	}

	static class Node {
		int item;
		Node left, right;
		public Node (int item) {
			this.item = item;
			left = right = null;
		}
	}

	static void printlevelorder(Node root) {
		if (root == null) return;
		Queue<Node> que = new ArrayDeque<>();
		que.add(root);
		
		while (!que.isEmpty()) {
			Node tmp = que.poll();
			System.out.print(tmp.item +  " " );
			if (tmp.left != null) que.add(tmp.left);
			if (tmp.right != null) que.add(tmp.right);
		}
	}
	
	static Node additem(Node root, int item) {	
		if (root == null) return new Node(item);
		else if (root.item < item) root.right = additem(root.right, item);
		else if (root.item > item) root.left = additem (root.left, item);	
		else return root;
		return root;
	}

	static void makeheap(Node root) {
		PriorityQueue<Integer> minheap = new PriorityQueue<>();
		Queue<Node> que = new ArrayDeque<>();
		que.add(root);
		
		while (!que.isEmpty()) {
			Node tmp = que.poll();
			minheap.add(tmp.item);
			if (tmp.left != null) que.add(tmp.left);
			if (tmp.right != null) que.add(tmp.right);
		}
		
		while (minheap.size() > 0) {
			System.out.print(minheap.poll());
		}	

	}
}
