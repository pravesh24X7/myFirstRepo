/**
 * Java code to reverse the given Linked List
 */

public class func3 {

    // Driver Code main function 
    public static void main(String[] args) {
        NodeOf head = null;
        int [] keys = {1,2,3,4,5,6,7,8,9};

        for (var key : keys) head = addNodeToLinkedList(head, key);
        func3 fc = new func3();
        System.out.println("printing the List");
        fc.printLinkedList(head);
        System.out.println("reversing the Linked List");
        head = reverseTheGivenList(head);
        fc.printLinkedList(head);

    }


    // static NodeOf LinkedList
    static class NodeOf {
        int item;
        NodeOf link;
        public NodeOf(int item) {
            this.item = item;
            link = null;
        }
    }

    // function to reverse the LinkedList
    public static NodeOf reverseTheGivenList(NodeOf head) {
        if (head == null || head.link == null) return head;
        NodeOf tmp = null, curr = head, next = null;
        while (curr != null) {
            next = curr.link;
            curr.link = tmp;
            tmp = curr;
            curr = next;
        }
        return tmp;
    }

    // function to print the Linked List
    public void printLinkedList(NodeOf head) {
        if (head != null) {
            System.out.print(head.item + " ");
            printLinkedList(head.link);
        }
    }

    // function to add Node to the Linked List
    public static NodeOf addNodeToLinkedList(NodeOf head, int key) {
        if (head == null) return new NodeOf(key);
        NodeOf tmp = head;
        while (tmp.link != null) {
            tmp = tmp.link;
        }
        tmp.link = new NodeOf(key);
        return head;
    }
}
