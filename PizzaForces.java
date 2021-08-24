package files_of_java;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class PizzaForces {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        List<Long> list = new ArrayList<>();
        int tc = input.nextInt();
        while (tc-- > 0) {
            long a, t, r, n;
            n = input.nextInt();

            a = n/6;
            r = n%6;

            if (n <= 6) t = 15; else if (r == 0) t = a * 15; else if (r <= 2)
                t = a * 15 + 5; else if (r <= 4) t = a * 15 + 10; else t = (a+1) * 15;
            list.add(t);
        }

        for (Long item : list) {
            System.out.println(item);
        }

        input.close();
    }

}
