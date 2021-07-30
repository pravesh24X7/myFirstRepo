package coreJava;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class OnlyEvenISReversed {
    public static void main(String[] args) {
        Node node = null;
        int[] values = new int[] {2, 18, 24, 3, 5, 7, 9, 6, 12};
        for (int item : values) node = addNode(node, item);
        reverse(node);
    }

    private static void printNode(Node node) {
        if (node != null) {
            System.out.print(node.item +  " " );
            printNode(node.node);
        }
    }

    private static Node reverse(Node node) {
        List<Integer> list = new ArrayList<>();
        for (Node tmp = node; tmp.node != null; tmp = tmp.node) {
            list.add(tmp.item);
        }
        int firstPlace = 0;
        for (int point=0; point < list.size();) {
            if (list.get(point)%2 == 0) firstPlace = point;
            while (list.get(point)%2 != 0) point++;
            changeOrder(list.subList(firstPlace, point));
        }
        for (Integer i : list) {
            node = addNode(node, i);
        }
        return node;
    }

    private static void changeOrder(List<Integer> list) {
        Collections.rotate(list, list.size()-1);
    }

    private static Node addNode(Node node, int item) {
        if (node == null) return new Node(item);
        var tmp = node;
        while (tmp.node != null) tmp = tmp.node;
        tmp.node = new Node(item);
        return node;
    }
    static class Node {
        int item;
        Node node;

        public Node(int item) {
            this.item = item;
            node = null;
        }
    }

}
