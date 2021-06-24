
public class fibonacci_heap {

    public class fibHeap {

        // public static fibHeap create_heap() {
        //     return new fibHeap();
        // }

        public fibHeap() {
            min = null;
            n = 0;
            trace = false;
        }


        Node min;
        public Node getMin() {
            return min;
        }
        public void setMin(Node min) {
            this.min = min;
        }
        public int getN() {
            return n;
        }
        public void setN(int n) {
            this.n = n;
        }
        public boolean isTrace() {
            return trace;
        }
        public void setTrace(boolean trace) {
            this.trace = trace;
        }
        public Node getFound() {
            return found;
        }
        public void setFound(Node found) {
            this.found = found;
        }
        int n;
        boolean trace;
        Node found;
    }

    
    static class Node {
        Node parent, left, right, child;
        int degree;
        boolean mark;
        int key;

        public Node() {
            this.degree = 0;
            this.mark = false;
            this.parent = null;
            this.left = this;
            this.right = this;
            this.child = null;
            this.key = Integer.MIN_VALUE;
        }

        public Node get_left() {
            return this.left;
        }

        public Node get_parent() {
            return this.parent;
        }

        public void set_left(Node x) {
            this.left = x;
        }

        public Node(int x) {
            this();
            this.key = x;
        }

        public void set_parent(Node x) {
            this.parent = x;

        }

        public void set_right(Node x) {
            this.right = x;
        }

        public Node et_right(Node x) {
            return this.right;
        }

        public void set_child(Node x) {
            this.child = x;
        }

        public Node get_child() {
            return this.child;
        }

        public void set_degree(int x) {
            this.degree = x;
        }

        public int get_degree() {
            return this.degree;
        }

        public void set_mark(boolean m) {
            this.mark = m;
        }

        public boolean get_mark() {
            return this.mark;
        }

        public void set_key(int x) {
            this.key = x;
        }

        public int get_key() {
            return this.key;
        }

    }


}