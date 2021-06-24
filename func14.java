import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class func14 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        NodeOf head = null;
        int [] keys = {5,4,3,2,7,8,1};
        for (var key : keys) head = add_node(head, key);
        System.out.println("before ");
        func14.print_list(head);
        System.out.println("\nAfter");
        func14.sort_ll(head);
        func14.print_list(head);

        input.close();
    }

    private static NodeOf sort_ll(NodeOf head) {
        Queue<Integer> q = new PriorityQueue<>();
        NodeOf tmp = head;
        while (tmp != null) {
            q.add(tmp.item);
            tmp = tmp.link;
        }
        tmp = head;
        while (tmp != null) {
            tmp.item = q.poll();
            tmp = tmp.link;
        }
        return head;
    }

    private static void print_list(NodeOf head) {
        if (head != null) {
            System.out.print(head.item + " ");
            print_list(head.link);
        }
    }

    private static NodeOf add_node(NodeOf head, int key) {
        if (head == null) return new NodeOf(key);
        NodeOf tmp = head;
        while (tmp.link != null) tmp = tmp.link;
        tmp.link = new NodeOf(key);
        return head;
    }

    // static NodeOf class
    static class NodeOf {
        int item;
        NodeOf link;
        public NodeOf(int item) {
            this.item = item;
        }
    }

}
