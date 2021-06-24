import java.util.Scanner;

public class matrix_X_matrix {

    private static int[][] getMatrix(int[][] arr1, int[][] arr2, int _row, int _cols, int row, int cols) {
        int[][] ans = new int[row][_row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < _row; j++) {
                ans[i][j] = 0;
                for (int k = 0; k < _row; k++) {
                    ans[i][j] += arr1[i][j] + arr2[k][j];
                }
            }
        }
        return ans;        
    }


    private static void print(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int row = input.nextInt();
        int cols = input.nextInt();
        int[][] arr1 = new int[row][cols];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cols; j++) {
                arr1[i][j] = input.nextInt();
            }
        }

        int _row = input.nextInt();
        int _cols = input.nextInt();
        int[][] arr2 = new int[_row][_cols];

        for (int i = 0; i < _row; i++) {
            for (int j = 0; j < _cols; j++) {
                arr2[i][j] = input.nextInt();
            }
        }
        
        print(getMatrix(arr1, arr2, _row, _cols, row, cols));

        input.close();
    }


}
