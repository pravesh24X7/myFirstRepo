import java.util.*;


public class colors {
    

    static class graph {
        List<List<Integer>> adjacency_list;

        graph(List<Edge> edges){
            adjacency_list = new LinkedList<>();
            int max = Integer.MIN_VALUE;

            for (Edge edge : edges) {
                max = Math.max(max, Math.max(edge.destination, edge.source));
            }

            for (int i=0; i<= max; i++) {
                adjacency_list.add(new LinkedList<>());
            }

            for (Edge edge : edges) {
                adjacency_list.get(edge.source).add(edge.destination);
                adjacency_list.get(edge.destination).add(edge.source);
            }
        }
    }


    static class Edge {
        int destination;
        int source;

        Edge(int destination, int source) {
            this.destination = destination;
            this.source =  source;
        }
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of edges");

        int total_edges = input.nextInt();
        List<Edge> edges = new LinkedList<>();

        for (int i=0; i<total_edges; i++) {
            System.out.println("Enter source and destination for " + i+1);
            int destination = input.nextInt();
            int source = input.nextInt();
            edges.add(new Edge(destination, source));
        }

        graph g = new graph(edges);

        System.out.println("Enter source for func_colors()");
        int source = input.nextInt();

        int size_forVisited = Integer.MIN_VALUE;
        
        for (Edge edge : edges) {
            size_forVisited = Math.max(size_forVisited, Math.max(edge.destination, edge.source));
        }

        boolean[] visited = new boolean[size_forVisited+1];
        int[] colour = new int[size_forVisited+1];
        func_colors(g, source, visited, colour);

        System.out.println(show_results(colour));
        System.out.println(Arrays.toString(colour));
        
        input.close();
    }


    static boolean show_results(int[] colour) {
        for (int i=0; i<colour.length; i++) {
            if (i+1 < colour.length && colour[i] == colour[i+1]) {
                return false;
            }
        }
        return true;
    }


    static void func_colors(graph g, int source, boolean[] visited, int[] colour) {
        Queue<Integer> q = new ArrayDeque<>();
        visited[source] = true;
        colour[source] = 1;
        q.add(source);
        
        int pointer = -1;

        while (!q.isEmpty()) {
            source = q.poll();

            for (Integer neighbour_OfSource : g.adjacency_list.get(source)) {
                if (!visited[neighbour_OfSource]) {
                    if (++pointer % 2 == 0) {
                        colour[neighbour_OfSource] = 0;
                    } else {
                        colour[neighbour_OfSource] = 1;
                    }
                    q.add(neighbour_OfSource);
                    visited[neighbour_OfSource] = true;
                }
            }
        }
    }

}