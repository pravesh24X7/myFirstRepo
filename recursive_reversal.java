public class recursive_reversal {
    public static void main(String[] args) {
        Node head = null;
        int[] items = {1,2,3,4,5,6,7,8,9};

        for (var item:items) head = add_item(head, item);
        print_list(head);
        head = reversal(head);
        System.out.println();
        print_list(head);
        Node prev = null, next = null;
        head = recursive_func(prev, head, next);
        print_list(head);
    }

    public static Node recursive_func(Node prev, Node curr, Node next) {
        if (curr == null) return prev; 
        next = curr.link;
        curr.link = prev;
        prev = curr;
        curr = next;  
        return prev;      
    }

    public static Node reversal(Node head) {
        Node prev=null, curr=head, next=null;

        while(curr!=null) {
            next = curr.link;
            curr.link = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
    public static void print_list(Node head) {
        if (head != null) {
            System.out.print(head.item + " ");
            print_list(head.link);
        }
    }

    public static Node add_item(Node head, int key) {
        if (head == null) return new Node(key);
        Node tmp = head;
        while (tmp.link != null) tmp = tmp.link;
        tmp.link = new Node(key);
        return head;
    }

    static class Node {
        int item;
        Node link = null;
        public Node(int item) {
            this.item = item;
        }
    }
}
