package recursion;


import java.util.Stack;
import java.util.Scanner;


public class StackSort
{

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        Stack<Integer> s = new Stack<>();

        for (int i=0; i<input.nextInt(); i++)
        {
            s.push(input.nextInt());
        }

        sort_stack(s);
        System.out.println(s);

        input.close();
    }


    static void sort_stack(Stack<Integer> s)
    {
        if (s.size() == 1 || s.size() == 0)
        {
            return;
        }

        int last = s.peek();
        s.pop();

        sort_stack(s);
        insert_InStack(s, last);
    }


    static void insert_InStack(Stack<Integer> s, int ele)
    {
        if (s.size() == 0 || s.peek() <= ele)
        {
            s.push(ele);
            return;
        }

        int last_idx = s.peek();
        s.pop();

        insert_InStack(s, ele);
        s.push(last_idx);
    }

}
