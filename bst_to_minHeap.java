import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.ArrayDeque;

public class bst_to_minHeap {

    public static void main(String[] args) {
        int[] keys = { 5, 3, 4, 8, 7, 9 };
        _Node_ root = null;

        for (var key : keys)
            root = _add_(root, key);
        
        print_tree(root);
        System.out.println("\n_bst_to_minHeap :" + _bst_to_minHeap(root));
    }


    public static List<Integer> _bst_to_minHeap(_Node_ root) {
        List<Integer> ll = new ArrayList<>();
        PriorityQueue<Integer> min_heap = new PriorityQueue<>();
        Queue<_Node_> q = new ArrayDeque<>();

        q.add(root);
        while (!q.isEmpty()) {
            _Node_ tmp = q.poll();
            min_heap.add(tmp.item);

            if (tmp.left != null)
                q.add(tmp.left);
            if (tmp.right != null)
                q.add(tmp.right);
        }
        
        while (min_heap.size() > 0) {
            ll.add(min_heap.peek());
            min_heap.poll();
        }
        return ll;

    }


    public static void print_tree(_Node_ root) {
        if (root != null) {
            print_tree(root.left);
            System.out.print(root.item + " ");
            print_tree(root.right);
        }
    }


    public static _Node_ _add_(_Node_ root, int key) {
        if (root == null)
            return new _Node_(key);
        else if (root.item > key)
            root.left = _add_(root.left, key);
        else if (root.item < key)
            root.left = _add_(root.left, key);
        else
            return root;
        return root;
    }

    
    static class _Node_ {
        int item;
        _Node_ left, right;

        public _Node_(int item) {
            this.item = item;
            left = right = null;
        }
    }


}
