public class BalancedBst {

    // Driver Code main function
    public static void main(String[] args) {
        java.util.Scanner input = new java.util.Scanner(System.in);
        avl_tree root = new avl_tree();
        System.out.println("AVL TREE :");
        char ch;
        do {
            System.out.println("\tOperations of AvlTree :");
            System.out.println("\t1. Insert");
            System.out.println("\t2. Search");
            System.out.println("\t3. Count Nodes");
            System.out.println("\t4. Check Empty");
            System.out.println("\t5. Clear Tree");

            int choice = input.nextInt();
            switch (choice) {
                case 1 : System.out.println("Enter integer element to insert :");
                root.insert(input.nextInt());
                break;
                case 2 : System.out.println("Enter integer element to search :");
                System.out.println("Search result :" + root.search(input.nextInt()));
                break;
                case 3 : System.out.println("Nodes = " + root.count_nodes());
                break;
                case 4 : System.out.println("Empty Status :" + root.is_empty());
                break;
                case 5 : System.out.println("Tree Cleared :");
                root.make_empty();
                break;
                default : System.out.println("Make a valid choice");
                break;
            }
            System.out.println("Post Order Traversal :");
            root.postorder_traversal();
            System.out.println();
            System.out.println("Pre Order Traversal :");
            root.preorder_traversal();
            System.out.println();
            System.out.println("In Order Traversal :");
            root.inorder_traversal();
            System.out.println();
            System.out.println("Do you want to continue {y,n} :");
            ch = input.next().charAt(0);
        } while (ch == 'y' || ch == 'Y');
        input.close();
    }



    static class avl_tree {
        private Node root;

        public avl_tree() {
            root = null;
        }

        public boolean is_empty() {
            return root == null;
        }

        public void make_empty() {
            root = null;
        }

        public void insert(int val) {
            root = insertion(val, root);
        }

        public int height(Node root) {
            return root == null ? -1 : root.height;
        }

        public int max(int lhs, int rhs) {
            return lhs > rhs ? lhs : rhs;
        }

        private Node rotate_left(Node root) {
            Node root1 = root.left;
            root.left = root1.right;
            root1.right = root;
            root.height = max(height(root.left), height(root.right)) + 1;
            root1.height = max(height(root1.left), root.height) + 1;
            return root1;
        }

        private Node rotate_right(Node root1) {
            Node root2 = root1.left;
            root1.right = root2.left;
            root2.left = root1;
            root1.height = max(height(root1.left), height(root1.right)) + 1;
            root2.height = max(height(root2.right), root1.height) + 1;
            return root2;
        }

        private Node double_with_leftChild(Node root3) {
            root3.left = rotate_right(root3.left);
            return rotate_left(root3);
        }


        public int count_nodes() {
            return count(root);
        }

        public int count(Node root) {
            if (root == null)
                return 0;
            else {
                int l = 1;
                l += count(root.left);
                l += count(root.right);
                return l;
            }
        }

        public boolean search(int val) {
            return finder(root, val);
        }

        private boolean finder(Node root, int val) {
            boolean found = false;
            while ((root != null) && !found) {
                int root_val = root.item;
                if (root_val < root_val)
                    root = root.left;
                else if (val > root_val)
                    root = root.right;
                else {
                    found = true;
                    break;
                }
                found = finder(root, val);
            }

            return found;
        }

        public void inorder_traversal() {
            inorder(root);
        }

        public void preorder_traversal() {
            preorder(root);
        }

        public void postorder_traversal() {
            postorder(root);
        }

        private void inorder(Node root) {
            if (root != null) {
                inorder(root.left);
                System.out.print(root.item + " ");
                inorder(root.right);
            }
        }

        private void preorder(Node root) {
            if (root != null) {
                System.out.print(root.item + " ");
                preorder(root.left);
                preorder(root.right);
            }
        }

        private void postorder(Node root) {
            if (root != null) {
                postorder(root.left);
                postorder(root.right);
                System.out.print(root.item + " ");
            }
        }


        private Node double_with_rightChild(Node root1) {
            root1.right = rotate_left(root1.right);
            return rotate_right(root1);
        }
        

        private BalancedBst.Node insertion(int val, BalancedBst.Node root) {
            if (root == null)
                root = new Node(val);
            else if (root.item > val) {
                root.left = insertion(val, root.left);
                if (height(root.left) - height(root.right) == 2)
                    if (val < root.left.item)
                        root = rotate_left(root);
                    else
                        root = double_with_leftChild(root);
            } else if (val > root.item) {
                root.right = insertion(val, root.right);
                if (height(root.right) - height(root.left) == 2)
                    if (val > root.right.item)
                        root = rotate_right(root);
                    else
                        root = double_with_rightChild(root);
            } else {
                root.height = max(height(root.left), height(root.right)) + 1;
                return root;
            }
            return root;
        }

    }


    static class Node {
        int item, height;
        Node left, right;

        public Node(int item) {
            height = 0;
            this.item = item;
            left = right = null;
        }

        public Node() {
            item = height = 0;
            left = right = null;
        }
    }

}
