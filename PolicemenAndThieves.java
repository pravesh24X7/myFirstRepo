package coreJava;
import java.util.Scanner;

public class PolicemenAndThieves {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int row = input.nextInt();
        int[][] grid = new int[row][row];

        for (int i=0; i<row; i++) {
            for (int j=0; j<row; j++) {
                grid[i][j] = input.nextInt();
            }
        }
        System.out.println(solution(grid));

        input.close();
    }

    private static int solution(int[][] arr) {
        int count = 0;
        for (int[] ints : arr) {
            int numberOfThieves = 0, numberOfPolicemen = 0;
            for (int j = 0; j < arr.length; j++)if (ints[j] == 1) numberOfPolicemen++;else numberOfThieves++;
            count += Math.abs(numberOfPolicemen - numberOfThieves);
        }
        return count;
    }

}
