// import java.util.ArrayList;
// import java.util.List;
// import java.util.PriorityQueue;

// public class chech_if_bstISHeap {
    
//     public static void main(String[] args) {
//         Node root = new Node(5);
//         root.left = new Node(6);
//         root.left.left = new Node(7);
//         root.left.right = new Node(8);
//         root.right = new Node(9);
//         root.right.left = new Node(10);

//         print_tree(root);
//     }


//     public static boolean checker(Node root) {
//         PriorityQueue<Integer> min_heap = new PriorityQueue<>();
//         List<Integer> ll = new ArrayList<>();
//         get_list(root, ll);

//         return true;
//     }

//     public static void get_list(Node root, List<Integer> ll) {
//         if (root != null) {
//             get_list(root.left, ll);
//             ll.add(root.item);
//             get_list(root.right, ll);            
//         }
//     }


//     public static void print_tree(Node root) {
//         if (root != null) {
//             print_tree(root.left);
//             System.out.print(root.item + " ");
//             print_tree(root.right);
//         }
//     }


//     static class Node {
//         int item;
//         Node left, right;

//         public Node(int item) {
//             this.item = item;
//             left = right = null;
//         }
//     }

// }
