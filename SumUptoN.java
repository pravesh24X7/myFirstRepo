package coreJava;

import java.util.Scanner;

public class SumUptoN
{

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int i = input.nextInt();
        System.out.println(solution(i));

        input.close();
    }

    private static int solution(int i)
    {
        if (i == 0 || i < 0)
        {
            return 0;
        }
        return i + solution(i-1);
    }

}
