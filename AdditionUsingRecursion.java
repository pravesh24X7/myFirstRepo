package coreJava;
import java.util.Scanner;

public class AdditionUsingRecursion {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arr = new int[input.nextInt()], arr2 = new int[input.nextInt()];
        Node node1 = null, node2 = null;

        for (int i=0; i<arr.length; i++) arr[i] = input.nextInt();
        for (int i=0; i<arr2.length; i++) arr2[i] = input.nextInt();

        for (var item : arr) node1 = addNode(node1, item);
        for (var item : arr2) node2 = addNode(node2, item);

        print(reverse(node1));
        print(reverse(node2));

        System.out.println();
        System.out.println(solution(node1, node2));

        input.close();
    }

    private static void print(Node node) {
        if (node != null) {
            System.out.print(node.item + " " );
            print(node.link);
        }
    }

    private static Node reverse(Node node) {
        var curr = node;
        Node prev = null, last;
        while (curr != null) {
            last = curr.link;
            curr.link = prev;
            prev = curr;
            curr = last;
        }
        return prev;
    }

    private static int solution(Node node1, Node node2) {
        if (node1 == null && node2 == null) return 0;
        if (node1 == null) return node2.item + solution(null, node2.link);
        if (node2 == null) return node1.item + solution(node1.link, null);
        return (node1.item + node2.item) + solution(node1.link, node2.link);
    }

    private static Node addNode(Node node, int item) {
        if (node == null) return new Node(item);
        var tmp = node;
        while (tmp.link != null) tmp = tmp.link;
        tmp.link = new Node(item);
        return node;
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
