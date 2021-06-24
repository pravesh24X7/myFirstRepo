import java.util.Scanner;

public class delete_KNode_LL {
    public static void main(String[] args) {
        Node head = null;
        Scanner input = new Scanner(System.in);
        
        var sx = input.nextShort();
        int[] arr_for_list = new int[sx];
        for (var idx=0; idx<sx; idx++) {
            arr_for_list[idx] = input.nextInt();
        }

        for (var idx:arr_for_list) head = add_item(head, idx);
        print_list(head);

        System.out.println("\nEnter loc :");
        var loc = input.nextInt();

        Node remover = (head != null) ? head : null;
        print_list(remover);
        delete_node(head, loc, remover);
        print_list(head);
        input.close();
    }

    private static void print_list(Node head) {
        if (head != null) {
            System.out.print(head.item + " ");
            print_list(head.link);
        }
    }

    private static void delete_node(Node head, int loc, Node remover) {
        if (loc == 1) {
            Node tmp = head;
            head = head.link;
            tmp.link = null;
        }
        if (loc == get_length(head)) {
            Node tmp = head, prev = null;
            while (tmp.link != null) {
                prev = tmp;
                tmp = tmp.link;
            }
            prev.link = null;
        }
        while (loc != 0) {
            delete_node(head, loc--, remover.link);
        }
        Node prev = head;
        while (prev.link != remover) {
            prev = prev.link;
        }
        prev.link = remover.link;
        remover.link = null;
    }

    private static int get_length(Node head) {
        byte counter = 0;
        Node tmp = head;
        while (tmp != null) {
            counter++;
            tmp = tmp.link;
        }
        return counter;
    }

    private static Node add_item(Node head, int key) {
        if (head == null) return new Node(key);
        Node tmp = head;
        while (tmp.link != null) tmp = tmp.link;
        tmp.link = new Node(key);
        return head;
    }
    
    static class Node {
        int item;
        Node link;
        public Node(int item) {
            this.item = item;
            link = null;
        }
    }

}
