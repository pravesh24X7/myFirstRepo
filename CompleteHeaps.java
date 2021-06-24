import java.util.PriorityQueue;
import java.util.Collections;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

public class CompleteHeaps extends CompleteBinarySearchTree implements NodeOfBinaryTree {

    /**
     * this method will merge the two LinkedList and return the final
     * LinkedList
     * @param head1
     * @param head2
     * @return
     */
    public static NodeOfBinaryTree.ListNode __mergeTwoLinkedList__(NodeOfBinaryTree.ListNode head1,
            NodeOfBinaryTree.ListNode head2) {
        NodeOfBinaryTree.ListNode ans = null;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        while (head1 != null) {
            minHeap.add(head1.item);
            head1 = head1.link;
        }
        while (head2 != null) {
            minHeap.add(head2.item);
            head2 = head2.link;
        }
        while (!minHeap.isEmpty()) {
            if (ans == null) {
                ans = new NodeOfBinaryTree.ListNode(minHeap.poll());
            } else {
                NodeOfBinaryTree.ListNode tmp = ans;
                while (tmp.link != null)
                    tmp = tmp.link;
                tmp.link = new NodeOfBinaryTree.ListNode(minHeap.poll());
            }
        }
        return ans;
    }

    /**
     * this is a helper function for __sort__ method, when the flag is true
     * @param arr
     * @param left
     * @param right
     */
    private static void __reverse__(int[] arr, int left, int right) {
        if (left < right) {
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
            __reverse__(arr, left, right);
        }
    }

    /**
     * this function will sort the given array in ascending order 
     * Worst Case TC : O(nlogn)
     * Space Complexity : O(N)
     * @param arr
     * @param flag
     */
    public static void __sort__(int[] arr, boolean flag) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        if (arr.length == 0 || arr.length == 1)
            return;
        for (int item : arr) {
            minHeap.add(item);
        }
        for (int i = 0; minHeap.size() > 0; i++, minHeap.poll())
            arr[i] = minHeap.peek();
        if (flag) {
            __reverse__(arr, 0, arr.length - 1);
            return;
        }
    }

    /**
     * this functions will merge the given two arrays and return 
     * List of integer to it
     * @param arr
     * @param arr2
     * @return
     */
    public static List<Integer> __mergeTwoArrays__(int[] arr, int[] arr2) {
        // System.arraycopy(src, srcPos, dest, destPos, length);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int item : arr) {
            minHeap.add(item);
        }
        for (int item : arr2) {
            minHeap.add(item);
        }
        List<Integer> result = new LinkedList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }
        return result;
    }


    /**
     * this will return true if given BinaryTree is Min. Heap, else
     * return false
     * @param root
     * @return
     */
    public static boolean __BTisMINHEAP__(BTNode root) {
        Queue<BTNode> q = new LinkedList<>();
        List<Integer> first = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            BTNode tmp = q.poll();
            first.add(tmp.item);
            if (tmp.left != null)
                q.add(tmp.left);
            if (tmp.right != null)
                q.add(tmp.right);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(first);
        List<Integer> sec = new LinkedList<>(minHeap);
        if (first.equals(sec))
            return true;
        return false;
    }

    /**
     * this will return Min. Heap of the given BinarySearchTree 
     * @param root
     * @return
     */
    public static List<Integer> __bstTOMinHeap__(Node root) {
        List<Integer> ans = new LinkedList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        if (root == null)
            return ans;
        if (root.left == null || root.right == null) {
            ans.add(root.item);
            return ans;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node tmp = q.poll();
            minHeap.add(tmp.item);
            if (tmp.left != null)
                q.add(tmp.left);
            if (tmp.right != null)
                q.add(tmp.right);
        }
        return new LinkedList<>(minHeap);
    }

    /**
     * this will return K Smallest element in the given array
     * @param arr
     * @param K
     * @return
     */
    public static int KSmallest(int[] arr, int K) {
        if (arr.length == 0)
            return Integer.MIN_VALUE;
        if (arr.length == 1)
            return arr[0];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int item : arr) {
            if (maxHeap.size() > K) {
                maxHeap.poll();
            }
            maxHeap.add(item);
        }
        return maxHeap.peek(); 
    }

    /**
     * this will return K Largest element in the given array 
     * @param arr
     * @param K
     * @return
     */
    public static int __KLargest__(int[] arr, int K) {
        if (arr.length == 0)
            return Integer.MAX_VALUE;
        if (arr.length == 1)
            return arr[0];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int item : arr) {
            if (minHeap.size() > K) {
                minHeap.poll();
            }
            minHeap.add(item);
        }
        return minHeap.peek();
    }


    /**
     * this will return true if the given array represents the minHeap
     * presentataion of array, else return false
     * @param arr
     * @return
     */
    public static boolean __trueHeapArray__(int[] arr) {
        if (arr.length == 0 || arr.length == 1)
            return true;
        for (int i = 0; i < (arr.length-2) / 2; i++) {
            if (arr[i] > arr[2 * i + 1] || (arr[2 * i + 2] > arr.length && arr[i] > arr[2 * i + 2]))
                return false;
        }
        return true;
    }


}
