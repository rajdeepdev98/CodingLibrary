import java.util.*;

/**
 * Algorithm: Weighted Graph Template
 * Time Complexity: O(V + E) for most operations
 * Space Complexity: O(V + E)
 * Use case: Foundation for weighted graph algorithms (Dijkstra, Bellman-Ford, etc.)
 */
public class WeightedGraph {

    // Constants
    static final int MAXN = 100005;
    static final long INF = (long)1e18;

    // Edge class
    static class Edge {
        int to;
        long weight;

        Edge(int to, long weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    // Data structures
    List<Edge>[] adj;
    int n;  // number of nodes
    boolean directed;

    // Constructor
    @SuppressWarnings("unchecked")
    public WeightedGraph(int n, boolean directed) {
        this.n = n;
        this.directed = directed;
        adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    // Add edge method
    void addEdge(int u, int v, long weight) {
        adj[u].add(new Edge(v, weight));
        if (!directed) {
            adj[v].add(new Edge(u, weight));
        }
    }

    // Get neighbors
    List<Edge> getNeighbors(int u) {
        return adj[u];
    }

    // Print graph
    void printGraph() {
        for (int i = 1; i <= n; i++) {
            System.out.print(i + " -> ");
            for (Edge e : adj[i]) {
                System.out.print("(" + e.to + ", " + e.weight + ") ");
            }
            System.out.println();
        }
    }

    // Main method with test case
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // TODO: Implement your test case here
        int n = sc.nextInt();  // number of nodes
        int m = sc.nextInt();  // number of edges

        WeightedGraph graph = new WeightedGraph(n, false);

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            long w = sc.nextLong();
            graph.addEdge(u, v, w);
        }

        graph.printGraph();

        sc.close();
    }
}
