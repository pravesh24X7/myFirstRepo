package programmingInJava.src.coreJava;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class ReveralsInJava {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Node node1 = null, node2 = null;

        int one, two;
        one = input.nextInt();
        two = input.nextInt();

        List<Integer> list = getListFromNumber(one);
        for (Integer item : list) {
            node1 = createNodes(node1, item);
        }

        list = getListFromNumber(two);
        for (Integer item : list) {
            node2 = createNodes(node2, item);
        }

        node1 = reversalOfNodes(node1);
        node2 = reversalOfNodes(node2);

        printList(finalInList(node1, node2));

        input.close();
    }

    private static List<Integer> getListFromNumber(int item) {
        List<Integer> list = new ArrayList<>();

        while (item > 0) {
            list.add(item % 10);
            item /= 10;
        }
        return list;
    }

    private static Node finalInList(Node node1, Node node2) {
        if (node1 == null && node2 == null) return null;
        Node copyOfNode1 = node1;
        Node copyOfNode2 = node2;

        int one = 0;
        int two = 0;

        while (copyOfNode1 != null) {
            one *= 10 + copyOfNode1.item;
            copyOfNode1 = copyOfNode1.link;
        }

        while (copyOfNode2 != null) {
            two *= 10 + copyOfNode2.item;
            copyOfNode2 = copyOfNode2.link;
        }

        one += two;
        
        Node answerNode = null, tail = null;

        while (one > 0) {
            if (answerNode == null) {
                tail = answerNode = new Node(one % 10);
            } else {
                tail.link = new Node(one % 10);
                tail = tail.link;
            }
            one /= 10;
        }
        
        return reversalOfNodes(answerNode);
    }

    private static Node reversalOfNodes(Node node) {
        // if (node.link == null || node == null) return node;

        Node next;
        Node prev = null, curr = node;

        while (curr != null) {
            next = curr.link;
            curr.link = prev;
            prev = curr;
            curr = next;
        }

        // node = (prev != null) ? prev : null;
        return prev;
    }

    private static Node createNodes(Node node, int item) {
        if (node == null) return new Node(item);
        Node tmp = node;
        while (tmp.link != null) {
            tmp = tmp.link;
        }
        tmp.link = new Node(item);
        return node;
    }

    private static void printList(Node node) {
        if (node != null) {
            System.out.print(node.item + " ");
            printList(node.link);
        }
    }

    static class Node {
        int item;
        Node link;

        Node(int item) {
            this.item = item;
            link = null;
        }
    }

}
