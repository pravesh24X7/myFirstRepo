/**
 * Java Code to get the intersection point of second Linked List
 */

import java.util.*;

public class func2 {
    
    // static Node of LinkedList
    static class NodeOf { 
        int item;
        NodeOf link;
        public NodeOf(int item) {
            this.item = item;
            link = null;
        }
    }

    // function to get the intersection point of the List
    public static void getIntersectionOfLinkedList(NodeOf head1, NodeOf head2, Map<Integer, Integer> map) {
        if (head1 == null || head2 == null) return;
        Set<Integer> set = new HashSet<>();
        
        NodeOf tmp1 = head1, tmp2 = head2;
        while (tmp1 != null) {
            set.add(tmp1.item);
            tmp1 = tmp1.link;
        }
        int i=0;
        while (tmp2 != null) {
            i++;
            if (set.contains(tmp2.item)) {
                map.put(i, tmp2.item);
                break;
            }
            tmp2 = tmp2.link;
        }
    }

    // function to print the Linked List
    public void printLinkedList(NodeOf head) {
        if (head != null) {
            System.out.print(head.item + " ");
            head = head.link;
        }
    } 

    // function to add a Node to the Linked List
    public static NodeOf addNodeToLinkedList(NodeOf head, int key) {
        if (head == null) return new NodeOf(key);
        NodeOf tmp = head;
        while (tmp.link != null) {
            tmp = tmp.link;
        }
        tmp.link = new NodeOf(key);
        return head;
    }


    public static void main(String[] args) {
        
        Map<Integer, Integer> map = new LinkedHashMap<>();
        int [] keys = {1,2,3,4,5,6,76,87,90};
        int [] keys2 = {12,54,76,87,90};

        NodeOf head1 = null;
        NodeOf head2 = null;
        for (var key : keys) head1 = addNodeToLinkedList(head1, key);
        for (var key : keys2) head2 = addNodeToLinkedList(head2, key);

        System.out.println("printing head1 :");
        func2 fc = new func2();
        fc.printLinkedList(head1);
        System.out.println("printing head2");
        fc.printLinkedList(head2);

        getIntersectionOfLinkedList(head1, head2, map);
        System.out.println("\n" + map.keySet());
    }
}
