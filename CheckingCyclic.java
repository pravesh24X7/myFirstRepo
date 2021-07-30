package coreJava;
import java.util.LinkedList;

/**
 * here we're checking whether the given graph is cyclic or not using the graph coloring algorithm
 **/

public class CheckingCyclic {
    static int black = 2, gray = 1, white = 0;

    public static void main(String[] args) {
        Graph g = new Graph(4);
        Graph.addEdge(g, 0, 1);
        Graph.addEdge(g, 0, 2);
        Graph.addEdge(g, 1, 2);
        Graph.addEdge(g, 2, 0);
        Graph.addEdge(g, 2, 3);
        Graph.addEdge(g, 3, 3);

        if (Graph.isCyclic(g)) System.out.println("Cyclic");else System.out.println("NotCyclic");
    }

    static class Graph {
        int v;
        LinkedList<Integer>[] adj;
        public Graph(int numberOfVertex) {
            v = numberOfVertex;
            adj = new LinkedList[v];
            for (int i=0; i<v; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        public static void addEdge(Graph g, int source, int destination) {
            g.adj[source].add(destination);
        }
        public static boolean dfsTraversal(Graph g, int source, int[] color) {
            color[source] = gray;
            for (Integer i : g.adj[source]) {
                if (color[i] == gray) return true;if (color[i] == white && dfsTraversal(g, i, color)) return  true;
            }
            color[source] = black;
            return false;
        }
        public static boolean isCyclic(Graph g) {
            int[] color = new int[g.v];
            for (int i=0; i<g.v; i++) color[i] = white;
            for (int i=0; i<g.v; i++)if (color[i] == white)if(dfsTraversal(g, i, color)) return true;
            return false;
        }
    }

}
