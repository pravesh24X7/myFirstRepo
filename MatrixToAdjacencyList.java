package recursion;

import java.util.*;

public class MatrixToAdjacencyList {

	static class Edge {
		int src, dest;

		Edge(int src, int dest) {
			this.dest = dest;
			this.src = src;
		}
	}

	static class Graph {
		List<List<Integer>> al;

		Graph(List<Edge> edges, int N) {
			al = new LinkedList<>();

			for (int i = 0; i < N + 1; i++) {
				al.add(new LinkedList<>());
			}

			for (Edge edge : edges) {
				al.get(edge.dest).add(edge.src);
				al.get(edge.src).add(edge.dest);
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[][] arr = new int[n + 1][n + 1];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = input.nextInt();
			}
		}

		List<Edge> edges = new LinkedList<>();
		makeListFromGrid(arr, edges);

		boolean[] vis = new boolean[n + 1];
		Graph g = new Graph(edges, n);

		performBFS(g, 1, vis);

		input.close();
	}

	private static void performBFS(Graph g, int i, boolean[] vis) {
		// TODO Auto-generated method stub

		Queue<Integer> q = new ArrayDeque<>();
		vis[i] = true;
		q.add(i);

		while (!q.isEmpty()) {
			i = q.poll();
			System.out.println("outgoing edges from " + i);

			for (var others : g.al.get(i)) {
				if (!vis[others]) {
					vis[others] = true;
					q.add(others);
					System.out.println(others);
				}
			}
		}

	}

	private static void makeListFromGrid(int[][] arr, List<Edge> edges) {
		// TODO Auto-generated method stub

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j] == 1) {
					edges.add(new Edge(i, j));
				}
			}
		}

	}

}
