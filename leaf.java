public class leaf {
    public static void main(String[] args) {
        int[] keys = {7, 5, 6, 4, 8, 9};
        bst root = null;

        for (var key:keys) root = add_keys(root, key);
        print_tree(root);
        System.out.println();
        System.out.println(get_leaf_count(root));
    }

    public static int get_leaf_count(bst root) {
        if (root == null) return 0;
        
        if (root.left == null && root.right == null) return 1;
        return get_leaf_count(root.left) + get_leaf_count(root.right);
    }


    public static void print_tree(bst root) {
        if (root != null) {
            print_tree(root.left);
            System.out.print(root.item + " ");
            print_tree(root.right);
        }
    }

    
    public static bst add_keys(bst root, int key) {
        if (root == null) return new bst(key);
        else if (root.item > key) root.left = add_keys(root.left, key);
        else if (root.item < key) root.right = add_keys(root.right, key);
        else return root;
        return root;
    }


    static class bst {
        int item;
        bst left, right;
        public bst(int item) {
            this.item= item;
            left = right = null;
        }
    }
}
