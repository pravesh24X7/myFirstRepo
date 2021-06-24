import java.util.Queue;
import java.util.ArrayDeque;

public class StackUsingQueue {

    public static void main(String[] args) {
        StackUsingQueue my_stack = new StackUsingQueue(5);
        my_stack.addItem(12);
        my_stack.addItem(34);
        my_stack.addItem(11);
        my_stack.addItem(90);
        my_stack.addItem(66);

        System.out.println(my_stack.getTop());
        System.out.println("printing Queue");
        my_stack.print();

        System.out.println(my_stack.removeItem());
        System.out.println(my_stack.removeItem());
        System.out.println(my_stack.removeItem());
        System.out.println(my_stack.removeItem());
        System.out.println(my_stack.removeItem());
    }

    public int getSize() {
        return que.size();
    }

    private static int top;
    private static int capacity;
    private static Queue<Integer> que;

    public StackUsingQueue() {
        que = new ArrayDeque<>();
        top = -1;
    }

    public StackUsingQueue(int capacity) {
        que = new ArrayDeque<>(capacity);
        StackUsingQueue.capacity = capacity;
        top = -1;
    }

    public int removeItem() {
        if (IsEmpty()) {
            System.out.println("Underflow Stack !!");
            return Integer.MIN_VALUE;
        }
        if (que.size() == 1)
            return que.poll();
    
        Queue<Integer> tmp = new ArrayDeque<>();
        while (que.size() > 1) {
            tmp.add(que.remove());
        }
        int ans = que.remove();
        while (!tmp.isEmpty()) {
            que.add(tmp.remove());
        }
        top--;
        return ans;
    }

    public boolean IsFull() {
        return que.size() == capacity;
    }

    public boolean IsEmpty() {
        return que.size() == 0;
    }

    public void print() {
        System.out.println(que);
    }

    public void addItem(int item) {
        if (IsFull()) {
            System.out.println("Overflow Stack !!");
            return;
        }
        que.add(item);
        top++;
    }

    public int getTop() {
        return top;
    }

}
