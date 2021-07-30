package recursion;


import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;


public class ArraySort
{

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        List<Integer> arr = new LinkedList<>();
        for (int i=0; i<input.nextInt(); i++)
        {
            arr.add(input.nextInt());
        }

        sort_list(arr);
        System.out.println(arr);

        input.close();
    }


    static void sort_list(List<Integer> arr)
    {
        if (arr.size() == 1 || arr.size() == 0)
        {
            return;
        }

        int last = arr.get(arr.size()-1);
        arr.remove(arr.size()-1);

        sort_list(arr);
        insert_InList(arr, last);
    }


    static void insert_InList(List<Integer> arr, int item)
    {
        if (arr.size() == 0 || arr.get(arr.size()-1) <= item)
        {
            arr.add(item);
            return;
        }

        int last_val = arr.get(arr.size()-1);
        arr.remove(arr.size()-1);
        insert_InList(arr, item);

        arr.add(last_val);
    }


}
