package coreJava;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


public class SwapNode {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int[] arr = new int[input.nextInt()];
		for (int i=0; i<arr.length; i++) {
			arr[i] = input.nextInt();
		}

		Node listNode = null;
		for (int  item : arr) {
			listNode = addNode(listNode, item);
		}
	
		List<Integer> list = new ArrayList<>();
	
		swapNodes(listNode, list);
		print(listNode);
		
		input.close();
	}

	private static void print(Node listNode) {
		if (listNode != null) {
			System.out.print( listNode.item +  " ");
			print(listNode.link);
		}
	}

	private static Node swapNodes(Node listNode, List<Integer> list) {
		if (listNode.link == null || listNode == null) return listNode;
		list.add(listNode.item);
		swapNodes(listNode.link, list);

		return makeList(list);
	}

	private static Node makeList(List<Integer> list) {
		if (list.size() >= 2) {
			var tmp = list.get(0);
			list.add(0, list.get(1));
			list.add(1, tmp);
		}
		
		for (int i=2; i<list.size(); i+=2) {
			if (i+1 < list.size()) {
				var tmp = list.get(i);
				list.add(i, list.get(i+1));
				list.add(i+1, tmp);
			}
		}
	
		Node ansNode = null;	
		for (Integer item : list) {
			ansNode = addNode(ansNode, item);
		}

		return ansNode;
	}	

	private static Node addNode(Node listNode, int item) {
		if (listNode == null) return new Node(item);
		Node tmp = listNode;
		while (tmp.link != null) tmp = tmp.link;
		tmp.link = new Node(item);
		return listNode;
	}

	static class Node {
		int item;
		Node link;

		public Node(int item) {
			this.item = item;
			link = null;
		}
	}

}
