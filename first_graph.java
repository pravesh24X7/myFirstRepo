import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Stack;

public class first_graph {

    public static void dfs_of_graph(Graph g, int src, boolean[] vis) {
        Stack<Integer> s = new Stack<>();
        vis[src] = true;
        s.add(src);

        while (!s.isEmpty()) {
            src = s.pop();
            System.out.print(src + " ");
            for (var adj_nodes : g.adjacentList.get(src)) {
                if (!vis[adj_nodes]) {
                    vis[adj_nodes] = true;
                    s.add(adj_nodes);
                }
            }
        }
    }


    public static void bfs_of_graph(Graph g, int src, boolean[] vis) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(src);
        vis[src] = true;

        while (!q.isEmpty()) {
            src = q.poll();
            System.out.print(src + " ");
            for (var adj_nodes : g.adjacentList.get(src)) {
                if (!vis[adj_nodes]) {
                    vis[adj_nodes] = true;
                    q.add(adj_nodes);
                }
            }
        }        
    }


    public static void main(String[] args) {
        List<Edge> edges = Arrays.asList(new Edge(1, 2), new Edge(2, 3), new Edge(3, 4), new Edge(3, 5),
                new Edge(4, 5));
        Graph g = new Graph(edges);
        // int max = 0;
        // for (Edge edge : edges) {
        //     max = Integer.max(max, Integer.max(edge.dest, edge.src));
        // }
        boolean[] vis_for_bfs = new boolean[6];
        boolean[] vis_for_dfs = new boolean[6];

        bfs_of_graph(g, 1, vis_for_bfs);
        System.out.println();
        dfs_of_graph(g, 1, vis_for_dfs);
        Arrays.fill(vis_for_bfs, false);
        
        System.out.println();
        System.out.println(presence(g, 1, 5, vis_for_bfs));

    }

    public static boolean presence(Graph g, int src, int dest, boolean[] vis) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(src);
        vis[src] = true;

        while (!q.isEmpty()) {
            src = q.poll();
            if (src == dest)
                return true;
            for (var adj_nodes : g.adjacentList.get(src)) {
                if (!vis[adj_nodes]) {
                    vis[adj_nodes] = true;
                    q.add(adj_nodes);
                }
            }
        }
        return false;
    }


    static class Graph {
        List<List<Integer>> adjacentList;

        public Graph(List<Edge> edges) {
            int max = 0;
            for (Edge edge : edges) {
                max = Integer.max(max, Integer.max(edge.dest, edge.src));
            }
            adjacentList = new ArrayList<>();
            for (var i = 0; i < max+1; i++) {
                adjacentList.add(new ArrayList<>());
            }
            for (Edge edge : edges) {
                adjacentList.get(edge.dest).add(edge.src);
                adjacentList.get(edge.src).add(edge.dest);
            }
        }
    }


    static class Edge {
        int src, dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }   
    

}
