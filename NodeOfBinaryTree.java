public interface  NodeOfBinaryTree {

    public static class BTNode {
        int item;
        BTNode left, right;

        public BTNode(int item) {
            this.item = item;
            left = right = null;
        }
    }

    public static class ListNode {
        int item;
        ListNode link;

        public ListNode(int item) {
            this.item = item;
            link = null;
        }
    }


}
