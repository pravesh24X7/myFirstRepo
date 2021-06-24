public class cursed_java {
    public static void main(String[] args) {
        Node_of_dll head = null;
        int[] items =  {1,2,3,4,5,6,7,87,9};

        for (var item:items) head = add_item(head, item);
        print_list(head);
        head = reverse(head);
        System.out.println();
        print_list(head);
    }


    public static Node_of_dll reverse(Node_of_dll head) {
        if (head == null || head.link == null) return head;
        Node_of_dll prev = null, curr = head, next = null;
        while (curr!= null) {
            next = curr.link;
            curr.link = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
    public static Node_of_dll add_item(Node_of_dll head, int key) {
        if (head == null) return new Node_of_dll(key);
        Node_of_dll tmp = head;
        while (tmp.link != null) tmp = tmp.link;
        Node_of_dll new_dllNode = new Node_of_dll(key);
        tmp.link = new_dllNode;
        new_dllNode.prev = tmp;
        return head;
    }


    public static void print_list(Node_of_dll head) {
        if (head != null) {
            System.out.print(head.item + " ");
            print_list(head.link);
        }
    }


    static class Node_of_dll {
        int item;
        Node_of_dll link, prev;
        public Node_of_dll(int item) {
            this.item = item;
            link = prev = null;
        }
    }
}
