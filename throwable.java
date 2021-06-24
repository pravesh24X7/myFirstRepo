import java.util.Scanner;

public class throwable {

    public static int get_set_go(int n1, int n2) throws Exception {

        if (n2 == 0) {
            throw new Exception("Invalid input");
        }
        return n1 / n2;
    }


    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        int n1 = input.nextInt();
        int n2 = input.nextInt();

        try {
            var result = get_set_go(n1, n2);
            System.out.println(result);
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            System.out.println("It's my Time Guys !!");
        }

        input.close();
    }

}
