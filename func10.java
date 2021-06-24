/**
 * Java code to perform the following operation
 * 
 *       Add two linked lists without using any extra space.
        Input :
            X : 5 -> 7 -> 3 -> 4 -> null
            Y : 9 -> 4 -> 6 -> null
     
        Output :
             6 -> 6 -> 8 -> 0 -> null
            (as 5734 + 946 = 6680)

 */

public class func10 {

    // Driver Code main function 
    public static void main(String[] args) {
        NodeOf head1 = null;
        NodeOf head2 = null;

        int [] keys1 = {5,7,3,4};
        int [] keys2 = {9, 4, 6};

        func10 fc = new func10();
        for (var key : keys1) head1 = fc.addNode(head1, key);
        for (var key : keys2) head2 = fc.addNode(head2, key);

        fc.printList(head1);
        System.out.println();
        fc.printList(head2);

        NodeOf resultHead = fc.getResult(head1, head2);
        System.out.println();
        resultHead = fc.reverseLinkedList(resultHead);
        fc.printList(resultHead);
        System.out.println();
        fc.printList(fc.clone_of_list(resultHead));
    }

    public NodeOf clone_of_list(NodeOf head) {
        NodeOf clone = null;
        while (head != null) {
            if (clone == null) {
                clone = new NodeOf(head.item);
                head = head.link;
            }
            NodeOf tmp = clone;
            while (tmp.link != null)  tmp = tmp.link;
            tmp.link = new NodeOf(head.item);
            head = head.link;
        }
        return clone;
    }

    // public fucntion to reverse the Linked List
    public NodeOf reverseLinkedList(NodeOf head) {
        if (head == null) {
            return head;
        }
        NodeOf tmp = null, curr = head, next = null;
        while (curr != null) {
            next = curr.link;
            curr.link = tmp;
            tmp = curr;
            curr = next;
        }
        return (tmp != null) ? tmp : null;
    }

    // public function to return the resultant NodeOf 
    public NodeOf getResult(NodeOf head1, NodeOf head2) {
        NodeOf newHead = null;
        if (head1 == null) return head2;
        else if (head2 == null) return head1;
        else {
            int resultant1 = 0, resultant2 = 0;
            NodeOf tmp1 = head1;
            while (tmp1 != null) {
                resultant1 = 10 * resultant1 + tmp1.item;
                tmp1 = tmp1.link;
            }
            NodeOf tmp2 = head2;
            while (tmp2 != null) {
                resultant2 = 10 * resultant2 + tmp2.item;
                tmp2 = tmp2.link;
            }
            int result = resultant1 + resultant2;
            while (result != 0) {
                int idx = result % 10;
                if (newHead == null) {
                    newHead = new NodeOf(idx);
                } else {
                    NodeOf tmp = newHead;
                    while (tmp.link != null) tmp = tmp.link;
                    tmp.link = new NodeOf(idx);
                }
                result /= 10;
            }
        }
        return newHead;
    }

    // public function to print the Linked List
    public void printList(NodeOf head) {
        if (head != null) {
            System.out.print(head.item + " ");
            printList(head.link);
        }
    }

    // public function to add Node to Linked List
    public NodeOf addNode(NodeOf head, int key) {
        if (head == null) {
            return new NodeOf(key);
        }
        NodeOf tmp = head;
        while (tmp.link != null) {
            tmp = tmp.link;
        }
        tmp.link = new NodeOf(key);
        return head;
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

}
