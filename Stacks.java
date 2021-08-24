package files_of_java;

public class Stacks {

    static int top=-1;

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        top = 5;
        int n=6;	

        printStack(arr, n);
        System.out.println("removing 2 item from the stack!!");
        popItem(arr, n);
        printStack(arr, n);
        System.out.println("adding 2 items into the stack!!");
        pushItem(arr, n);
        printStack(arr, n);
    }

    public static void pushItem(int[] arr, int n) {
        if (top == (n-1)) {
            System.out.println("stack is full ");
        }
        int[] tmp = {6,7,8,9,21,43};
		  System.out.println(java.util.Arrays.toString(tmp));
        int count = 2;
        for (int i=top; i<n; i++) {
            if (count == 0) break;
            arr[i+1] = tmp[i];
            count--;
	         top++;
        }
    }

    public static void popItem(int[] arr, int n) {
        if (top == -1)
        {
            System.out.println("stack is empty");     
        }
        int count = 2;        
        for (int i=top; i>=0; i--) {
            if (count == 0) break;
            System.out.println(arr[i]);
            count--;
	         top--;
        }
    }

    public static void printStack(int[] arr, int n) {
        if (top == -1) {
            return;
        }
        for (int i=top; i>=0; i--) {
            System.out.print(arr[i] + " ");
        }
    }
}
