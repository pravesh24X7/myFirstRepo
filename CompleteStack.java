public class CompleteStack {

    /**
     * this is used to access the current Capacity of Stack
     * @return
     */
    public static int getCapacity() {
        return capacity;
    }
    
    /**
     * this is used to change the Capacity of Stack
     * @param capacity
     */
    public static void setCapacity(int capacity) {
        CompleteStack.capacity = capacity;
    }
    
    /**
     * private data memebers of CompleteStack Class, that are used to
     * manage Stack
    */
    private static int capacity;
    private static int size;
    private static int top;
    private static Node head;

    /**
     * @return the top of the Stack
     */
    public static int getTop() {
        return top;
    }
    

    /**
     * static Node of LinkedList that is ued to implement Stack 
     */
    static class Node {
        int item;
        Node link;

        public Node(int item) {
            this.item = item;
            link = null;
        }
    }

    /** 
     * @return true if Stack if Full
     */
    public static boolean IsFull() {
        return size == capacity;
    }

    /**
     * @return true if the Stack is Empty
     */
    public static boolean IsEmpty() {
        return size == 0;
    }

    /**
     * public constructor of CompleteStack Class 
     * @param capacity it is used to initialise the capacity of Stack
     */
    public CompleteStack(int capacity) {
        CompleteStack.capacity = capacity;
        size = 0;
        top = -1;
        head = null;
    }

    /**
     * 
     * @param item this will add the requested item in the Stack
     * @throws Exception if Stack is full this will throw an Exception
     */
    public static void addItem(int item) throws Exception {
        if (IsFull()) {
            throw new Exception("Stack Is Full");
        }
        if (head == null) {
            head = new Node(item);
            size++; top++;
            return;
        } else {
            Node tmp = head;
            while (tmp.link != null) {
                tmp = tmp.link;
            }
            tmp.link = new Node(item);
            size++; top++;
            return;
        }
    }

}
