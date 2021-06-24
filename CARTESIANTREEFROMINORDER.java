public class CARTESIANTREEFROMINORDER {
	public static void main(String[] args) {
		int[] arr = {9, 3, 7, 1, 8, 12, 10, 20, 15, 18, 5};
		print(arr);
		System.out.println();

		printinorder(maketree(arr, 0, arr.length - 1));
	}

	static void print(int[] arr) {
		for (int item : arr) System.out.print(item + " ");
 	}

	static class Node {
		int item;
		Node left, right;
		Node(int item) {
			this.item = item;
			left = right = null;		
		}
	}
	
	static Node maketree(int[] arr, int start, int end) {
		if (start > end) {
			return null;
		}			
		int idx = min(arr, start, end);
		Node root = new Node(arr[idx]);

		root.left = maketree(arr, start, idx - 1);
		root.right = maketree(arr, idx + 1, end);
		return root;
	}		

	static int min(int[] arr, int start , int end) {
		int idx = start;

		for (int i = start + 1; i <= end; i++) {
			if (arr[idx] > arr[start]) idx = start;
		}
		return idx;
	}
	
	static void printinorder(Node root) {
		if (root != null) {
			printinorder(root.left);
			System.out.print(root.item + " " );
			printinorder(root.right);
		}
	}	
}
