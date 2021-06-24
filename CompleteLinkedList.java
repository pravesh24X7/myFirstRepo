import java.util.Set;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.List;
import java.util.LinkedList;

public class CompleteLinkedList {

    /**
     * this function will return true if the given LinkedList if palindrome, 
     * else return false
     * @param head
     * @return
     */
    public static boolean __palindrome__(Node head) {
        if (head == null || head.link == null)
            return true;
        Stack<Integer> stk = new Stack<>();
        Queue<Integer> q = new ArrayDeque<>();
        Node tmp = head;
        while (tmp != null) {
            stk.add(tmp.item);
            q.add(tmp.item);
            tmp = tmp.link;
        }
        while (!stk.isEmpty() && !q.isEmpty()) {
            if (stk.peek() != q.peek())
                return false;
            stk.pop();
            q.poll();
        }
        return true;
    }

    /**
     * this will return the addition of LinkedList elements and return the 
     * LinkedList to it.
     * @param head1
     * @param head2
     * @return
     */
    public static Node __ListOfAddition__(Node head1, Node head2) {
        Node __final__ = null;
        long add = __SumOfItems__(head1) + __SumOfItems__(head2);
        while (add > 0) {
            long __new__ = add % 10;
            if (__final__ == null) {
                __final__ = new Node((int) __new__);
            } else {
                Node tmp = __final__;
                while (tmp.link != null)
                    tmp = tmp.link;
                tmp.link = new Node((int) __new__);
            }
            add /= 10;
        }
        return __reverse__(__final__);
    }

    /**
     * this functions will add all the elements of the LinkedList and return
     * the result of addition.
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     * @param head
     * @return
     */
    public static long __SumOfItems__(Node head) {
        long var1 = 0;
        while (head != null) {
            var1 = head.item + var1 * 10;
            head = head.link;
        }
        long ans = 0;
        while (var1 > 0) {
            ans += var1 % 10;
            var1 /= 10;
        }
        return ans;
    }

    /**
     * this function will delete the LinkedList and return null
     * @param head
     * @return
     */
    public static Node __delete__(Node head) {
        head = null;
        return head;
    }

    /**
     * this will sort the LinkedList in ascending Order Using HeapSort 
     * Worst Case TC : O(nlogn)
     * Space Complexity : O(n)
     * @param head
     * @return
     */
    public static Node __sort__(Node head, boolean flag) {
        if (head == null || head.link == null)
            return head;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Node tmp = head;
        while (tmp != null) {
            minHeap.add(tmp.item);
            tmp = tmp.link;
        }
        tmp = head;
        while (!minHeap.isEmpty()) {
            tmp.item = minHeap.poll();
            tmp = tmp.link;
        }
        if (flag)
            return __reverse__(head); 
        return head;
    }

    /**
     * this function will return true if there is a Loop in LinkedList, else
     * return false
     * @param head
     * @return
     */
    public static boolean __loopDetection__(Node Head) {
        if (Head == null || Head.link == null)
            return false;
        Set<Node> s = new HashSet<>();
        Node head = Head;
        while (head != null) {
            if (s.contains(head))
                return true;
            s.add(head);
            head = head.link;
        }
        return false;
    }

    /**
     * this will remove all the duplicate element from the LinkedList
     * @param head
     * @return
     */
    public static Node __removeDups__(Node head) {
        Set<Integer> set = new HashSet<>();
        Node tmp = head;
        while (tmp != null) {
            set.add(tmp.item);
            tmp = tmp.link;
        }
        tmp = null;
        for (Integer item : set) {
            tmp = __add_(tmp, item);
        }
        return tmp;
    }
    
    /**
     * this will return the Min. element of LinkedList
     * @param head
     * @return
     */
    public static int __min__(Node head) {
        if (head == null)
            return Integer.MAX_VALUE;
        if (head.link != null)
            return head.item;
        int ans = Integer.MAX_VALUE;
        Node tmp = head;
        while (tmp != null) {
            ans = Integer.min(ans, tmp.item);
        }
        return ans;
    }

    /**
     * this will return the Max. element of LinkedList
     * @param head
     * @return
     */
    public static int __max__(Node head ) {
        if (  head== null)
            return Integer.MIN_VALUE;
        if (head.link == null)
            return head.item;
        Node tmp = head;
        int ans = Integer.MIN_VALUE;
        while (tmp != null) {
            Integer.max(ans, tmp.item);
        }
        return ans;
    }


    /**
     * this method will delete the Middle element of given LinkedList
     * @param  head 
     * @return
     */
    public static Node __deleteMid__(Node head ) {
        return __delete__ (head, __mid__(head));
    }


    /**
     * this will return the middle element of the given LinkedList
     * @param head 
     * @return
     */
    public static int __mid__(Node head ) {
        if ( head== null)
            return Integer.MIN_VALUE;
        if  (head.link == null)
            return head .item;
        Node slow = head , fast = head .link;
        while (fast != null) {
            slow = slow.link;
            fast = fast.link.link;
        }
        return slow.item;
    }


    /**
     * this will return the clone of the given LinkedList
     * @param head
     * @return
     */
    public static Node __clone__(Node head) {
        Node __new__ = null, tmp = head;
        List<Integer> items = new LinkedList<>();
        while (tmp != null) {
            items.add(tmp.item);
            tmp = tmp.link;
        }
        for (Integer item : items) {
            __new__ = __add_(__new__, item);
        }
        return __new__;
    }

    /**
     * this will rotate the given LinkedList from the given position
     * @param head
     * @param pos
     * @return
     */
    public static Node __rotate__(Node head, int pos) {
        if (pos == __len__(head)) {
            return __reverse__(head);
        } else if (pos == 0) {
            return head;
        } else {
            int pointer = 0;
            Node tmp = head, prev = null;
            while (pointer != pos) {
                while (tmp.link != null) {
                    prev = tmp;
                    tmp = tmp.link;
                }
                prev.link = null;
                tmp.link = head;
                head = tmp;
                pointer++;
            }
        }
        return head;
    }

    /**
     * this function will return the length of the LinkedList
     * @param head
     * @return
     */
    public static int __len__(Node head) {
        int count = 0;
        if (head == null)
            return 0;
        else if (head.link == null)
            return 1;
        else {
            Node tmp = head;
            while (tmp != null) {
                count++;
                tmp = tmp.link;
            }
        }
        return count;
    }

    /**
     * method to delete the head Node of the LinkedList
     * @param head
     * @return
     */
    public static Node __deleteHead__(Node head) {
        if (head == null || head.link != null)
            return null;
        Node tmp = head;
        head = head.link;
        tmp.link = null;
        return head;
    }

    /**
     * method to delete the last node of the LinkedList
     * @param head
     * @return
     */
    public static Node __deleteTail__(Node head) {
        if (head == null || head.link == null)
            return null;
        Node tmp = head, prev = null;
        while (tmp.link != null) {
            prev = tmp;
            tmp = tmp.link;
        }
        prev.link = null;
        return head;
    }
    
    /**
     * method to delete the key from the specific position
     * @param head
     * @param pos
     * @return
     */
    public static Node __deleteFromPos__(Node head, int pos) {
        if (pos == 1) {
            return __deleteHead__(head);
        } else if (pos == __len__(head)) {
            return __deleteTail__(head);
        } else {
            Node tmp = head, prev = null;
            int pointer = 1;
            while (pos != pointer) {
                prev = tmp;
                tmp = tmp.link;
                pointer++;
            }
            prev.link = tmp.link;
            tmp.link = null;
        }
        return head;
    }

    /**
     * method to delete the requested key from the LinkedList
     * @param head
     * @param key
     * @return
     */
    public static Node __delete__(Node head, int key) {
        if (head == null)
            return head;
        else if (head.item == key && head.link == null)
            return null;
        else {
            Node tmp = head, prev = null;
            while (tmp.item != key) {
                prev = tmp;
                tmp = tmp.link;
            }
            prev.link = tmp.link;
            tmp.link = null;
        }
        return head;
    }

    /**
     * this will return the reverse of given LinkedList
     * @param head
     * @return
     */
    public static Node __reverse__(Node head) {
        if (head == null || head.link == null)
            return head;
        Node prev = null, curr = head, next = null;
        while (curr != null) {
            next = curr.link;
            curr.link = prev;
            prev = curr;
            curr = next;
        }
        return (prev != null) ? prev : null;
    }

    /**
     * ,ethod to print the given LinkedList
     * @param head
     */
    public static void __print__(Node head) {
        if (head != null) {
            System.out.print(head.item + " ");
            __print__(head.link);
        }
    }

    /**
     * this will add the requested key to the LinkedList
     * @param head
     * @param item
     * @return
     */
    public static Node __add_(Node head, int item) {
        if (head == null)
            return new Node(item);
        Node tmp = head;
        while (tmp.link != null) {
            tmp = tmp.link;
        }
        tmp.link = new Node(item);
        return head;
    }

    /**
     * static Node of LinkedList
     */
    public static class Node {
        int item;
        Node link;

        public Node(int item) {
            this.item = item;
            link = null;
        }
    }

}
