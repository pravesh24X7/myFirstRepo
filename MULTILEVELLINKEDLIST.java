import java.util.PriorityQueue;
import java.util.Queue;
import java.util.ArrayDeque;

public class MULTILEVELLINKEDLIST {
	
	static class Node {
		int item;
		Node node, child;
		Node(int item, Node node, Node child) {
			this.item = item;
			this.node = node;
			this.child = child;
		}
	}

	public static void main(String[] args) {
		Node head = create(new int[] {1,2,3,4,5});
		head.child = create(new int[] {6,7});
		head.node.node.child = create(new int[] {8,9});
		head.child.node.child = create(new int[] {10,11});
		head.child.node.child.child = create(new int[] {12});

		print(convert(head));
	}

	private static void print(SLL node) {
		if (node != null) {
			System.out.print(node.item);
			print(node.link);
		}
	}

	private static Node create(int[] arr) {
		Node head = null;
		for (int i = 0; i < arr.length; i++) {
			head = new Node(arr[i], head, null);
		}
		return head;
	}

	static class SLL {
		int item;
		SLL link;
		SLL(int item) {
			this.item = item;
			link = null;
		}
	}

	private static SLL convert(Node head) {
		if (head == null) return null;
		if (head.node != null) return new SLL(head.item);
		
		Queue<Node> que = new ArrayDeque<>();
		PriorityQueue<Integer> minheap = new PriorityQueue<>();

		que.add(head);
		while (!que.isEmpty()) {
			Node tmp = que.poll();
			minheap.add(tmp.item);
			
			if (tmp.node != null) que.add(tmp.node);
			if (tmp.child != null) que.add(tmp.child);
		}		
		
		SLL node = null;
		while (minheap.size() > 0) {
			if (node == null) return new SLL(minheap.poll());
			else {
				SLL tmp = node;
				while (tmp.link != null) tmp = tmp.link;
				tmp.link = new SLL(minheap.poll());
			}
		}
		return node;
	}	
		
	

}
