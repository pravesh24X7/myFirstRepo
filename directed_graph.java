import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Arrays;

public class directed_graph {

    public static void main(String[] args) {
        List<Edge> edges = Arrays.asList(new Edge(2, 1), new Edge(2, 3), new Edge(3, 4), new Edge(3, 5));
        Graph g = new Graph(edges);
        boolean[] vis = new boolean[6];

        bfs_of_graph(g, 2, vis);
        Arrays.fill(vis, false);
        System.out.println(presence(g, 1, 5, vis));
    }


    public static boolean presence(Graph g, int src, int dest, boolean[] vis) {
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        vis[src] = true;

        while (!q.isEmpty()) {
            src = q.poll();
            if (src == dest)
                return true;
            for (var adj_nodes : g.adj_list.get(src)) {
                if (!vis[adj_nodes]) {
                    vis[adj_nodes] = true;
                    q.add(adj_nodes);
                }
            }
        }
        return false;
    }
    


    public static void bfs_of_graph(Graph g, int src, boolean[] vis) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(src);
        vis[src] = true;

        while (!q.isEmpty()) {
            src = q.poll();
            System.out.print(src + "  ");
            for (var adj_nodes:g.adj_list.get(src)) {
                if (!vis[adj_nodes]) {
                    vis[adj_nodes] = true;
                    q.add(adj_nodes);
                }
            }
        }
    }

    static class Graph {
        List<List<Integer>> adj_list;

        public Graph(List<Edge> edges) {
            adj_list = new LinkedList<>();
            int max = 0;
            for (Edge edge : edges) {
                max = Integer.max(max, Integer.max(edge.dest, edge.src));
            }
            for (var i = 0; i < max + 1; i++)
                adj_list.add(new LinkedList<>());
            for (Edge edge : edges) 
                adj_list.get(edge.src).add(edge.dest);
        }
    }
    

    static class Edge {
        int src, dest;

        public Edge(int src, int dest) {
            this.dest = dest;
            this.src = src;
        }
    }
}
