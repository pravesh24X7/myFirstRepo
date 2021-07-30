import java.util.*;

class Edge {
	int dest, source;
	public Edge(int dest, int source) {
		this.dest = dest;
		this.source = source;
	}

}

class Graph {
	List<List<Integer>> adjList;
	public Graph(List<Edge> edges, int N) {
		adjList = new LinkedList<>();
		for (int i=0; i<=N; i++) {
			adjList.add(new LinkedList<>());
		}
	
		for (Edge edge : edges) {
			adjList.get(edge.dest).add(edge.source);
			adjList.get(edge.source).add(edge.dest);
		}
	}

}

class Main {
	private static String[] colors = { "blue", "red", "violet", "indigo", "green", "yellow", "orange" };

	public static void main(String[] args) {
		List<Edge> edges = Arrays.asList( new Edge(0,1), new Edge(0,4), new Edge(0, 5), new Edge(4,5), new Edge(1,4), new Edge(1,3), new Edge(2,3), new Edge(2,4));
		
		int max_value = Integer.MIN_VALUE;

		for (Edge edge : edges) {
			max_value = Math.max(max_value, Math.max(edge.dest, edge.source));
		}
		
		Graph graph = new Graph(edges, max_value);
		color_graph(graph, max_value);
	}

	public static void color_graph(Graph graph, int N) {
		// to keep track of color assigned to each vertex 
		Map<Integer, Integer> map = new HashMap<>();
		
		// assign a color to a vertex one by one 
		for (int i=0; i<N; i++) {
			Set<Integer> set = new HashSet<>();
			for (int u: graph.adjList.get(i)) {
				if (map.containsKey(u)) {
					set.add(map.get(u));
				}
			}

			int color = 1;
			for (Integer j : set) {
				if (color != j) {
					break;
				}
				color++;
			}
			
			map.put(i, color);
		}

		for (int i=0; i<N; i++) {
			System.out.println("Color to vertex " +  i + " is " + colors[map.get(i)]);
		}

	}

}
