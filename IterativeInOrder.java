import java.util.Stack;

public class IterativeInOrder {

    public static void main(String[] args) {
        Node root = null;
        int[] arr = { 5, 6, 4, 7, 3, 8, 2 };

        for (int item : arr)
            root = addNode(root, item);
        print(root);
    }
    

    static class Node {
        int item;
        Node left, right;

        Node(int item) {
            this.item = item;
            left = right = null;
        }

    }

    public static void print(Node root) {
        if (root != null) {
            Stack<Node> s = new Stack<>();
            Node tmp = root;
            while (tmp != null || s.size() > 0) {
                while (tmp != null) {
                    s.push(tmp);
                    tmp = tmp.left;
                }
                tmp = s.pop();
                System.out.println(tmp.item);
                tmp = tmp.right;
            }
        }
    }

    public static Node addNode(Node root, int item) {
        if (root == null)
            return new Node(item);
        else if (root.item > item)
            root.left = addNode(root.left, item);
        else if (root.item < item)
            root.right = addNode(root.right, item);
        else
            return root;
        return root;
    }

}
