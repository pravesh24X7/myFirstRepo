/**
 * Java code to made a Generic Queue
 */

public class func9 {

    public static void main(String[] args) {
        func9 fc = new func9(5);

        for (var i=0; i<=5; i++) {
            fc.enQueue(i+1);
        }
        fc.printQueue();
        System.out.println( "getfront :" + fc.getFront());
        System.out.println( "getRear :"  + fc.getRear());
        System.out.println( "peek or getFront are same :"  + fc.peekInQueue());
        for (int i=0; i<=5; ++i) {
            System.out.println(fc.deQueue());
        }
    }
    
    // declaring arr to store the elements of Queue
    private int [] arr;
    private int size, rear, front, capacity;
    
    public func9(int capacity) {
        arr = new int[capacity];
        this.capacity = capacity;
        size = front = 0;
        rear = capacity -1 ;
    }

    public int getRear(){
        if (isEmpty()) {
            System.out.println("empty Queue");
            return Integer.MIN_VALUE;
        }
        return arr[rear];
    }

    public int getFront() {
        if(isEmpty()) {
            System.out.println("empty Queue");
            return Integer.MIN_VALUE;
        }
        return arr[front];
    }

    boolean isEmpty() {
        return size == 0;
    }

    boolean isFull() {
        return size == capacity;
    }

    public int peekInQueue() {
        if (isEmpty()) {
            System.out.println("Empty Queue");
            return Integer.MIN_VALUE;
        }
        return arr[front];
    }

    public void printQueue() {
        if(isEmpty()) {
            System.out.println("[]");
            return;
        }
        for (var i=front; i<=rear; ++i) {
            System.out.print(arr[i] + " ");
        }
    }

    public void enQueue(int key) {
        if (isFull()) {
            System.out.println("Data can't be inserted !!");
            return;
        }
        rear = (rear+1) % capacity;
        arr[rear] = key;
        size++;
    }

    public int deQueue() {
        if(isEmpty()) {
            System.out.println("Data can't be deleted !!");
            return Integer.MIN_VALUE;
        }
        int x = arr[front];
        front = (front+1) % capacity;
        size--;
        return x;
    }

}
