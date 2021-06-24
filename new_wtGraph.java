import java.util.LinkedList;

public class new_wtGraph {

    static class Edge {
        int src, dest, weight;

        public Edge(int src, int dest, int weight) {

            this.weight = weight;
            this.dest = dest;
            this.src = src;
        }
    }


    public class Graph {
        LinkedList<LinkedList<Edge>> adj_list;
        int vertices;

        public Graph(int vertices) {
            this.vertices = vertices;
            adj_list = new LinkedList<>();

            for (int i = 0; i < vertices + 1; i++) {
                adj_list.add(new LinkedList<>());
            }
        }

        public void addEdge(int src, int dest, int weight) {
            Edge edge = new Edge(src, dest, weight);
            adj_list.get(src).addFirst(edge);
        }

    }


}
