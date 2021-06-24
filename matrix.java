public class matrix {

    private static void pattern5(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j >= 0; j--) {
                if (i == j) {
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
        }
    }


    private static void pattern4(int[][] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < arr.length; j++) {
                if (Math.abs(j - i) == i || i == j) {
                    System.out.print(arr[i][j]);
                }
            }
            System.out.println();
        }
    }


    private static void pattern3(int[][] arr) {
        for (int i = arr.length-1; i >= 0; i--) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j) {
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
        }
    }


    private static void pattern2(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j) {
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
        }
    }


    private static void pattern1(int[][] arr) {
        for (int i = arr.length-1; i >=0; i--) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }


    private static void pattern(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        int[][] arr = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        System.out.println();
        pattern(arr);
        System.out.println();
        pattern1(arr);
        System.out.println();
        pattern2(arr);
        System.out.println();
        pattern3(arr);
        System.out.println();
        pattern4(arr);
        System.out.println();
        pattern5(arr);
        System.out.println();

    }


}
