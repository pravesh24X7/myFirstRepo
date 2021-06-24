import java.util.PriorityQueue;

public class intersection_of_ll {

    public static void main(String[] args) {
        int[] items = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        Node node = null;

        for (var key : items)
            node = add_item(node, key);

        print(node);
        sort(node);
        System.out.println();
        print(node);
    }


    public static void sort(Node node) {
        PriorityQueue<Integer> min_heap = new PriorityQueue<>();
        Node t = node;
        while (t != null) {
            min_heap.add(t.item);
            t = t.link;
        }
        t = node;
        while (!min_heap.isEmpty()) {
            t.item = min_heap.poll();
            t = t.link;
        }
    }


    static class Node {
        int item;
        Node link;

        public Node(int item) {
            this.item = item;
        }
    }
    
    
    public static Node add_item(Node node, int key) {
        if (node == null)
            new Node(key);
        Node tmp = node;
        while (tmp.link != null)
            tmp = tmp.link;
        tmp.link = new Node(key);
        return node;
    }


    public static void print(Node node) {
        if (node != null) {
            System.out.print(node.item + " ");
            print(node.link);
        }
    }


}
