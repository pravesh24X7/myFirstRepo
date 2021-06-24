import java.util.Stack;

public class QueueUsingStack {

    public static void main(String[] args) {
        QueueUsingStack my_queue = new QueueUsingStack(5);

        my_queue.addItem(12);
        my_queue.addItem(45);
        my_queue.addItem(78);
        my_queue.addItem(41);
        my_queue.addItem(55);

        my_queue.print();
        System.out.println(my_queue.getFront());
        System.out.println(my_queue.getRear());
        System.out.println(my_queue.getSize());

        System.out.println(my_queue.removeItem());
        System.out.println(my_queue.removeItem());
        System.out.println(my_queue.removeItem());
        System.out.println(my_queue.removeItem());
        System.out.println(my_queue.removeItem());

    }

    public int getSize() {
        return stk.size();
    }

    public int removeItem() {
        if (IsEmpty()) {
            System.out.println("Underflow Queue");
            return Integer.MIN_VALUE;
        }
        if (stk.size() == 1)
            return stk.pop();

        front++;
        Stack<Integer> tmp = new Stack<>();
        while (stk.size() > 1) {
            tmp.add(stk.pop());
        }
        int ans = stk.pop();
        while (!tmp.isEmpty()) {
            stk.add(tmp.pop());
        }
        return ans;
    }

    public void addItem(int item) {
        if (IsFull()) {
            System.out.println("Overflow Queue");
            return;
        }
        if (front == -1)
            front++;
        stk.add(item);
        rear++;
        return;
    }

    public int getRear() {
        return rear;
    }

    public int getFront() {
        return front;
    }

    private static int front, rear;
    private static int capacity;
    private static Stack<Integer> stk;

    
    public QueueUsingStack() {
        stk = new Stack<>();
        front = -1;
        rear = -1;
    }

    public QueueUsingStack(int capacity) {
        QueueUsingStack.capacity = capacity;
        stk = new Stack<>();
        front = -1;
        rear = -1;
    }

    public void print() {
        System.out.println(stk);
    }

    public static boolean IsEmpty() {
        return stk.size() == 0;
    }

    public static boolean IsFull() {
        return stk.size() == capacity;
    }    

}
