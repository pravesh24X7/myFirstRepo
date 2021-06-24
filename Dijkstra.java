import java.util.Set;
import java.util.Map.Entry;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;

/**
 * Dijkstra Algorithm in Java
 */
public class Dijkstra {

    public static void main(String[] args) {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D"); 
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");

        nodeA.addDestination(nodeB, 10);
        nodeA.addDestination(nodeC, 15);

        nodeB.addDestination(nodeD, 12);
        nodeB.addDestination(nodeF, 15);

        nodeC.addDestination(nodeE, 10);

        nodeD.addDestination(nodeE, 2);
        nodeD.addDestination(nodeF, 1);

        nodeF.addDestination(nodeE, 5);

        Graph graph = new Graph();

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);

        graph = Dijkstra.calc_shortestPath(graph, nodeA);
    }


    public static Graph calc_shortestPath(Graph g, Node src) {
        src.setDistance(0);

        Set<Node> settledNode = new HashSet<>();
        Set<Node> un_setteledNode = new HashSet<>();

        un_setteledNode.add(src);

        while (un_setteledNode.size() != 0) {
            Node curr_node = getLowestDist(un_setteledNode);
            un_setteledNode.remove(curr_node);

            for (Entry<Node, Integer> adjacent_pair : curr_node.getAdjacentNodes().entrySet()) {
                Node adjacent_node = adjacent_pair.getKey();
                Integer edge_weight = adjacent_pair.getValue();

                if (!settledNode.contains(adjacent_node)) {
                    calc_minDist(adjacent_node, edge_weight, curr_node);
                    un_setteledNode.add(adjacent_node);
                }
            }
            settledNode.add(curr_node);
        }
        return g;
    }


    private static void calc_minDist(Dijkstra.Node adjacent_node, Integer edge_weight, Dijkstra.Node curr_node) {
        Integer src_dist = curr_node.getDistance();
        if (src_dist + edge_weight < adjacent_node.getDistance()) {
            adjacent_node.setDistance(src_dist + edge_weight);
            LinkedList<Node> shortest_path = new LinkedList<>(curr_node.getShortestPath());
            shortest_path.add(curr_node);
            adjacent_node.setShortestPath(shortest_path);
        }
    }


    private static Dijkstra.Node getLowestDist(Set<Dijkstra.Node> un_setteledNode) {
        Node low = null;
        int low_dist = Integer.MAX_VALUE;
        for (Node node : un_setteledNode) {
            int node_dist = node.getDistance();
            if (node_dist < low_dist) {
                low_dist = node_dist;
                low = node;
            }
        }
        return low;
    }


    static class Node {
        private String name;
        private List<Node> shortestPath = new LinkedList<>();
        private int distance = Integer.MAX_VALUE;

        Map<Node, Integer> adjacentNodes = new HashMap<>();

        public void addDestination(Node dest, int dist) {
            adjacentNodes.put(dest, dist);
        }

        public Node(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Node> getShortestPath() {
            return shortestPath;
        }

        public void setShortestPath(List<Node> shortestPath) {
            this.shortestPath = shortestPath;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public Map<Node, Integer> getAdjacentNodes() {
            return adjacentNodes;
        }

        public void setAdjacentNodes(Map<Node, Integer> adjacentNodes) {
            this.adjacentNodes = adjacentNodes;
        }

    }


    static class Graph {
        Set<Node> nodes = new HashSet<>();

        public void addNode(Node a) {
            nodes.add(a);
        }

        public Set<Node> getNodes() {
            return nodes;
        }

        public void setNodes(Set<Node> nodes) {
            this.nodes = nodes;
        }

    }

    
}