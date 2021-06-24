public class transitiveClosure {

    final static int V = 4;


    public static void tc(int[][] g) {
        int[][] reach = new int[V][V];

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                reach[i][j] = g[i][j];
            }
        }

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    reach[i][j] = (reach[i][j] != 0) || ((reach[i][k] != 0) && (reach[k][j] != 0)) ? 1 : 0;
                }
            }
        }
        print_grid(reach);
    }


    private static void print_grid(int[][] reach) {
        for (int i=0; i<V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(reach[i][j] + " ");
            }
            System.out.println();
        }
    }



    public static void main(String[] args) {
        int[][] g = {
                { 1, 1, 0, 1 },
                { 0, 1, 1, 0 },
                { 0, 0, 1, 1 },
                { 0, 0, 0, 1 }
        };

        tc(g);
    }


}
