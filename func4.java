import java.util.*;

public class func4 {

    // Driver Code main function 
    public static void main(String[] args) {
        int [] keys1 = {1,4,5,7,9};
        int [] keys2 = {2,3,8,10,12};

        NodeOf head1 = null, head2 = null;
        for (var key : keys1) head1 = addNodeToLinkedList(head1, key);
        for (var key : keys2) head2 = addNodeToLinkedList(head2, key);

        func4 fc = new func4();
        fc.printLinkedList(head1);
        fc.printLinkedList(head2);

        NodeOf newHead = mergeTwoSortedList(head1, head2);
        fc.printLinkedList(newHead);
    }
    
    // static NodeOf Linked List
    static class NodeOf {
        int item;
        NodeOf link;
        public NodeOf(int item) {
            this.item = item;
            link = null;
        }
    }

    // function to merge two sorted Linked List into one final List
    public static NodeOf mergeTwoSortedList(NodeOf head1, NodeOf head2) {
        List<Integer> ll = new ArrayList<>(), ll2 = new ArrayList<>();
        if (head1 == null && head2 == null) return null;
        if (head1 == null) return head2; else if (head2 == null) return head1;

        while (head1 != null) {
            ll.add(head1.item);
            head1 = head1.link;
        }
        while (head2 != null) {
            ll2.add(head2.item);
            head2 = head2.link;
        }
        Integer [] arr1 = (Integer[]) ll.toArray(), arr2 = (Integer[]) ll2.toArray();
        int i = 0, j = 0;
        ArrayList<Integer> all = new ArrayList<>();
        while (i < arr1.length || j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                all.add(arr1[i]);
                i++;
            } else {
                all.add(arr2[j]);
                j++;
            }
            if (i == (arr1.length-1) || j == (arr2.length-1)) {
                break;
            }
        }
        while (i != arr1.length) {
            all.add(arr1[i]);
            i++;
        }
        while (j != arr2.length) {
            all.add(arr2[j]);
            j++;
        }
        NodeOf newHead = null;
        i = 0;
        while (!all.isEmpty()) {
            if (newHead == null) {
                newHead = new NodeOf(all.remove(i));
                i++;
            }
            NodeOf tmp = newHead;
            while (tmp.link != null) tmp = tmp.link;
            tmp.link = new NodeOf(all.get(i));
            i++;
        }
        return newHead;
    }

    // function to add Node to Linked List
    public static NodeOf addNodeToLinkedList(NodeOf head, int key) {
        if (head == null) return new NodeOf(key);
        NodeOf tmp = head;
        while (tmp.link != null) {
            tmp = tmp.link;
        }
        tmp.link = new NodeOf(key);
        return head;
    }

    // function to print the Linked List
    public void printLinkedList(NodeOf head) {
        if (head != null) {
            System.out.print(head.item + " ");
            head = head.link;
        }
    }
}
