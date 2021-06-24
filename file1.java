import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Stack;

public class file1 {

	static class Edge {
		int src, dest, weight;
		public Edge(int src, int dest, int weight) {
			this.weight = weight;
			this.dest = dest;
			this.src = src;
		}
	}


	static class Graph {
		List<List<Integer>> adj;

		Graph(List<Edge> edges) {
			adj = new LinkedList<>();
			int n = 0;

			for (Edge edge : edges) {
				n = Integer.max(n, Integer.max(edge.src, edge.dest));
			}

			for (int i=0; i<=n; i++) {
				adj.add(new LinkedList<>());
			}
			for (Edge edge : edges) {
				adj.get(edge.src).add(edge.dest);
			}
		}
	}

	public static void bt(Graph g, int src, boolean[] vis) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(src);
		vis[src] = true;

		while (!q.isEmpty()) {
			src = q.poll();
			System.out.print(src + " ");

			for (Integer nodes : g.adj.get(src)) {
				if (!vis[nodes]) {
					vis[nodes] = true;
					q.add(nodes);
				}
			}
		}
	}

	public static void dt(Graph g, int src, boolean[] vis) {
		Stack<Integer> s = new Stack<>();
		s.add(src);
		vis[src] = true;

		while (!s.isEmpty()) {
			src = s.pop();
			System.out.print(src + " ");

			for (Integer nodes : g.adj.get(src)) {
				if (!vis[nodes]) {
					vis[nodes] = true;
					s.add(nodes);
				}
			}
		}
	}

	public static void main(String[] args) {
		List<Edge> edges = Arrays.asList(
				new Edge(0, 1, 1), new Edge(1, 2, 5), new Edge(1, 3, 4), new Edge(3, 4, 2)
				);
		Graph g = new Graph(edges);
		boolean[] vis = new boolean[5];

		bt(g, 0, vis);
		Arrays.fill(vis, false);
		System.out.println();
		dt(g, 0, vis);
		dij(g, 0);
	}

	public static boolean path_checker(Graph g, int src, int dest, boolean[] vis) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(src);
		vis[src] = true;

		while (!q.isEmpty()) {
			src = q.poll();
			if (src == dest) {
				return true;
			}

			for (Integer nodes : g.adj.get(src)) {
				if (!vis[nodes]) {
					vis[nodes] = true;
					q.add(nodes);
				}
			}
		}

		return false;
	}

	public static void dij(Graph g, int src) {
		int[] dist = new int[g.adj.size()];

		boolean[] set = new boolean[dist.length];
		for (int i=0; i<dist.length; i++) {
			dist[i] = Integer.MAX_VALUE;
			set[i] = false;
		}

		dist[src] = 0;
		for (int count=0; count < dist.length-1; count++) {
			int u = min_dist(g, dist, set);
			set[u] = true;

			for (int v = 0; v < dist.length; v++) {
				if (!set[v] && g.adj.get(u).get(v) != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + g.adj.get(u).get(v) < dist[v]) {
					dist[v] = dist[u] + g.adj.get(u).get(v);
				}
			}
		}

		print(g, dist);
	}

	public static void print(Graph g, int[] dist) {
		System.out.println("Vertex \t\t Distance from source");
		for (int i=0; i<g.adj.size(); i++) {
			System.out.println(i + "\t\t" + dist[i]);
		}
	}

	public static int min_dist(Graph g, int[] dist, boolean[] set) {
		int min = Integer.MAX_VALUE, min_idx = -1;
		for (int v = 0; v < g.adj.size(); v++) {
			if (set[v] == false && dist[v] <= min) {
				min = dist[v];
				min_idx = v;
			}
		}
		return min_idx;
	}

}
