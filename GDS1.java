import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class GDS1 {
	public static void main(String[] args) {
		List<Edge> edges = Arrays.asList(new Edge(1,2), new Edge(1,3), new Edge(0,5), new Edge(2,0));
		Graph g = new Graph(edges);
		
		bfs(g, 1);
		System.out.println();
		dfs(g, 1);
	}

	static class Edge {
		int src, dest;
		Edge(int src, int dest) {
			this.src = src;
			this.dest = dest;
		}
	}

	static class Graph {
		List<List<Integer>> a;
		public Graph(List<Edge> edges) {
			a=new LinkedList<>();
			int m = 0;
			for (Edge edge : edges) {
				m = Integer.max(m, Integer.max(edge.dest, edge.src));
			}
			for (int i = 0; i < m + 1; i++) {
				a.add(new LinkedList<>());
			}
			for (Edge edge : edges) {
				a.get(edge.dest).add(edge.src);
				a.get(edge.src).add(edge.dest);
			}
		}
	}

	public static void bfs(Graph g, int s) {
		boolean[] vis = new boolean[g.a.size() + 1];
		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		vis[s] = true;

		while (!q.isEmpty()) {
			s = q.poll();
			System.out.print(s + " " );
			for (Integer an : g.a.get(s)) {
				if (!vis[an]) {
					vis[an] = true;
					q.add(an);
				}
			}
		}
	}

	public static void dfs(Graph g, int s) {
		boolean[] vis = new boolean[g.a.size() + 1];
		Stack<Integer> __s = new Stack<>();
		__s.add(s);
		vis[s] = true;
	
		while (!__s.isEmpty()) {
			s = __s.pop();
			System.out.print(s +  " ");
			for (Integer an : g.a.get(s)) {
				if (!vis[an]) {
					vis[an] = true;
					__s.add(an);
				}
			}
		}
	}

}
		
