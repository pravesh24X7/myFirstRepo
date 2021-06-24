import java.util.Scanner;;

public class mat_add {

    public static int[][] add(int[][] a, int[][] b) {
        int[][] ans = new int[a.length][a.length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                ans[i][j] = a[i][j] + b[i][j];
            }
        }

        return ans;
    }


    public static void print(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int row = input.nextInt(), cols = input.nextInt();
        int[][] grid = new int[row][cols];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = input.nextInt();
            }
        }

        row = input.nextInt();
        cols = Integer.parseInt(input.next());

        int[][] grid1 = new int[row][cols];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cols; j++) {
                grid1[i][j] = input.nextInt();
            }
        }

        print(add(grid, grid1));

        input.close();
    }


}
