import java.util.Queue;
import java.util.ArrayDeque;

public class DMEO {

	static class Node {
		int item;
		Node left, right;

		public Node(int item) {
			this.item = item;
			left = right = null;
		}
	}

	public static Node  add_item(Node root, int item) {
		if (root == null) return new Node(item);
		else if (root.item < item) root.right = add_item(root.right, item);
		else if (root.item > item) root.left = add_item(root.left, item);
		else return root;
		return root;
	}

	public static void print(Node root) {
		if (root != null) {
			print(root.left);
			System.out.print(root.item + " ");
			print(root.right);
		}
	}

	public static boolean same(Node root, Node __root) {
		if ((root == null && __root != null) || (root != null && __root == null)) return false;
		if (root == null && __root == null) return true;
		return ((root.item == __root.item) && same(root.left, __root.left) && same(root.right, __root.right));
	}

	public static void printRV(Node root) {
		if (root == null) return;
		Queue<Node> q = new ArrayDeque<>();
		q.add(root);

		while(!q.isEmpty()) {
			int n = q.size();
			for (int i = 1; i <= n; i++) {
				Node tmp = q.poll();
				if (i == 1) {
					System.out.print(tmp.item + " ");
				}
				if (tmp.right != null) q.add(tmp.right);
				if (tmp.left != null) q.add(tmp.left);
			}
		}
	}

	public static void printLV(Node root) {
		if (root == null) return;
		Queue<Node> q = new ArrayDeque<>();
		q.add(root);

		while (!q.isEmpty()) {
			int n = q.size();
			for (int i = 1; i <= n; i++) {
				Node tmp = q.poll();
				if (i == 1) {
					System.out.print(tmp.item + " ");
				}
				if (tmp.left != null) q.add(tmp.left);
				if (tmp.right != null) q.add(tmp.right);
			}
		}
	}

	public static boolean isBst(Node root) {
		if (root == null) return true;
		if (root.item > root.left.item && root.item < root.right.item) return true;
		return ( isBst(root.left) && isBst(root.right));
	}

	public static void main(String[] args) {
		Node root = null, __root = null;
		int[] items = {5,6,7,4,9,8};
		int[] __items = {5,2,4,3,1,6};

		for (int item : items) {
			root = add_item(root, item);
		}
		for (int item: __items) {
			__root = add_item(__root, item);
		}

		System.out.println("Tree 1 :");
		print(root);
		System.out.println("\nTree 2 :");
		print(__root);
		System.out.println("\n" + same(root, __root));
		System.out.println();
		printLV(root);
		System.out.println();
		printRV(__root);
		Node root__ = new Node(5);
		root__.left = new Node(4);
		root__.left.left = new Node(2);
		root__.left.left.right = new Node(3);
		root__.right = new Node(6);
		root__.right.right = new Node(9);
		root__.right.right.left = new Node(7);
		root__.right.right.left.right = new Node(1);
		root__.right.right.right = new Node(10);

		System.out.println("\nBst STATUS :" + isBst(root__));
	}
}
