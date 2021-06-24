public class MERGESORTONDOUBLYLINKEDLIST {
	public static void main (String[] args) {
		int[] arr = {7,6,5,4,3,2,1,8,9};
		Node head = null;
		
		for (int item : arr) head = additem(head, item);
		print(head);
		mergesort(head);
		System.out.println();
		print(head);
	}

	static class Node {
		int item;
		Node prev, link;
		Node(int item ) {
			this.item = item;
			link = prev = null;
 		}
	}

	private static Node additem(Node head, int item) {
		if (head == null) return new Node(item);
		Node tmp = head;
		while (tmp.link != null) tmp = tmp.link;		
		Node newnode = new Node(item);
		tmp.link = newnode;
		newnode.prev = tmp;
		return head;
	}

	private static void print(Node head) {
		if (head != null) {
			System.out.print(head.item +  " ");
			print(head.link);
		}		
	}

	private static Node mergesort(Node head) {
		if (head == null || head.link == null) return head;
		Node a, b;
		a = head;
		Node mid = midnode(head);
		b = mid.link;
		mid.link = null;
		a = mergesort(a);
		b = mergesort(b);
		head = merge(a, b);
		return head;
	}

	private static Node midnode(Node head) {
		if (head == null || head.link == null) return head;
		Node fast, slow;
		slow = head; fast = head.link;
	
		while (fast != null) {
			fast = fast.link;
			if (fast != null) {
				slow = slow.link;
				fast = fast.link;
	
			}
		}
		return slow;
	}

	private static Node merge(Node a, Node b) {
		if (a == null && b == null) return null;
		else if (a == null) return b;
		else if (b == null) return a;
		else if (a.item < b.item) {
			a.link = merge(a.link, b);
			a.link.prev = a;
			a.prev = null;
			return a;
		} else {
			b.link = merge(a, b.link);
			b.link.prev = b;
			b.prev = null;
			return b;
		}
	}
}
