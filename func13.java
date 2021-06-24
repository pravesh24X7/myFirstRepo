/**
 * Java Code to clone a Linked List
 */

public class func13 {

    public static void main(String[] args) {
        NodeOf head = null;
        int [] keys = {1,2,3,4,5,7,8,9};
        func13 fc = new func13();

        for (int key : keys) head = fc.add_node(head, key);
        fc.printList(head);
        System.out.println("cloned List :");
        fc.printList(fc.clone_of_list(head));
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

    public NodeOf add_node(NodeOf head, int key) {
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

    public void printList(NodeOf head) {
        if (head != null) {
            System.out.print(head.item + " ");
            head= head.link;
        }
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
