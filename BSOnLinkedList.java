import java.util.Scanner;

public class BSOnLinkedList {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        ListNode head = null;
        for (int i=0; i<size; i++) {
            head = addNode(head, input.nextInt());
        }
        System.out.println("you've inputted the following list");
        print(head);

        System.out.println("enter value to search in this list");
        int searchKey = input.nextInt();

        System.out.println(search(head, searchKey));

        input.close();
    }

    static ListNode getMid(ListNode start, ListNode last) {
        if (start == null) {
            return null;
        }

        ListNode fast = start.link;
        ListNode slow = start;

        while (fast != last) {
            fast = fast.link;
            if (fast != last) {
                slow = slow.link;
                fast = fast.link;
            }
        }

        return slow;
    }

    static ListNode search(ListNode node, int item) {
        ListNode start = node;
        ListNode last = null;

        do {
            ListNode midNode = getMid(start, last);
            if (midNode == null) return null;
            if (midNode.item == item) return midNode; else if (midNode.item > item)
                start = midNode.link; else last = midNode;
        } while (last == null || last != start);

        return null;
    }

    static void print(ListNode node) {
        var tmp = node;
        while (tmp != null) {
            System.out.print(tmp.item + " ");
            tmp = tmp.link;
        }
    }

    static ListNode addNode(ListNode node, int item) {
        if (node == null) {
            return new ListNode(item);
        }
        ListNode tmp = node;
        while (tmp.link != null) tmp = tmp.link;
        tmp.link = new ListNode(item);
        return node;
    }

    static class ListNode {
        int item;
        ListNode link;

        public ListNode(int item) {
            this.item = item;
            link = null;
        }
    }

}