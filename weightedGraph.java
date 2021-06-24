import java.util.List;
import java.util.LinkedList;

public class weightedGraph {

    public static void main(String[] args) {
        int vertices = 6;
        Graph g = new Graph(vertices);
        g.addEdge(0, 1, 4);
        g.addEdge(0, 2, 3);
        g.addEdge(1, 3, 2);
        g.addEdge(1, 2, 5);
        g.addEdge(2, 3, 7);
        g.addEdge(3, 4, 2);
        g.addEdge(4, 0, 4);
        g.addEdge(4, 1, 4);
        g.addEdge(4, 5, 6);

        g.print_graph();
    }


    static class Edge {
        int src, dest, weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }


    static class Graph {
        LinkedList<Edge>[] adj_list;
        int vertices;

        Graph(int vertices) {
            this.vertices = vertices;
            adj_list = new LinkedList[vertices];

            for (int i=0;i<vertices;i++) {
                adj_list[i] = new LinkedList<>();
            }
        }

        public void addEdge(int src, int dest, int weight) {
            Edge edge = new Edge(src, dest, weight);
            adj_list[src].add(edge);
        }

        public void print_graph() {
            for (int i = 0; i < vertices; i++) {
                LinkedList<Edge> list = (LinkedList<weightedGraph.Edge>) adj_list[i];
                for (int j = 0; j < list.size(); j++) {
                    System.out.println(i + " -> " + list.get(i).dest + " wt. " + list.get(i).weight);
                }
            }
        }
        
    }



}
