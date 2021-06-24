public class stack_reversal {
    public static void main(String[] args) {
        stack_reversal sr = new stack_reversal(5);

        for (var i=0; i<5; i++) {
            sr.add_items(i+1);
        }

        sr.print_stack();
        sr.revrese_stack();
        System.out.println();
        sr.print_stack();
    }

    
    int[] arr;
    int top, size, capacity;

    public stack_reversal(int capacity) {
        this.capacity = capacity;
        size = 0;
        top = -1;
        arr = new int[capacity];
    }

    public void print_stack() {
        for (var t=top; t>=0; t--) {
            System.out.print(arr[t] + " ");
        }
    }

    public boolean is_full() {
        return size == capacity;
    }

    public boolean is_empty() {
        return size == 0;
    }

    private void swap_arr_items(int l, int r) {
        var tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }

    private void master_reversal(int lb, int ub) {
        if (ub > lb) {
            swap_arr_items(lb, ub);
            lb++; ub--;
            master_reversal(lb, ub);
        }
    }

    public void revrese_stack() {
        master_reversal(0, size-1);
    }

    public void add_items(int key) {
        if (is_full()) {
            return;
        }
        arr[++top] = key;
        size++;
    }
}
