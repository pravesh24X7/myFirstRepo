class NewFile {

    static class stack {

    // stack variables

    int[] arr;
    int size;
    int top;
    int capacity;
    
    /*
    constructor to initialize stack
    @param capacity 
    * 
    */

    public stack(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        size = 0;
        top = -1;
    }

    // stack class methods 

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getTop() {
        return top;
    }

    public int peek() {
        if (top < 0) {
            System.out.println("[]");
        }
        return arr[top];
    }

    public void pop() {
        if (top < 0) {
            System.out.println("Underflow Stack !!");
            return;
        }
        size--;
        arr[top--] = Integer.MIN_VALUE;
    }
    
    public void push(int item) {
        if (size == capacity) {
            System.out.println("Overflow Stack !!");
            return;
        }
        arr[++top] = item;
        size++;
    }

    public void showStack() {
        System.out.println(java.util.Arrays.toString(arr));
    }

    }


    public static void main(String[] args) {
        java.util.Scanner input = new java.util.Scanner(System.in);
        stack my_stack = new stack(input.nextInt());

        for (int i=0; i<my_stack.getSize(); i++) {
            my_stack.push(input.nextInt());
        }

        reverseStack(my_stack);
        my_stack.showStack();

        input.close();
    }


    static void reverseStack(stack my_stack) {
        if (my_stack.getSize() == 1) {
            return;
        }

        int last_item = my_stack.peek();
        my_stack.pop();

        reverseStack(my_stack);
        insert_back(my_stack, last_item);
    }

    static void insert_back(stack my_stack, int value) {
        if (my_stack.getSize() == 0) {
            my_stack.push(value);
            return;
        }

        int last_item = my_stack.peek();
        insert_back(my_stack, value);

        my_stack.push(last_item);
    }

}