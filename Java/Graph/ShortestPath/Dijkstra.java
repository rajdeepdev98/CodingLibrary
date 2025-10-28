import java.util.*;

/**
 * Algorithm: Dijkstra's Shortest Path
 * Time Complexity: O((V + E) log V) with priority queue
 * Space Complexity: O(V + E)
 * Use case: Single-source shortest path in graphs with non-negative weights
 */
public class Dijkstra {

    static final long INF = (long)1e18;

    static class Edge {
        int to;
        long weight;

        Edge(int to, long weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Node implements Comparable<Node> {
        int vertex;
        long dist;

        Node(int vertex, long dist) {
            this.vertex = vertex;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node other) {
            return Long.compare(this.dist, other.dist);
        }
    }

    List<Edge>[] adj;
    long[] dist;
    int n;

    @SuppressWarnings("unchecked")
    public Dijkstra(int n) {
        this.n = n;
        adj = new ArrayList[n + 1];
        dist = new long[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
            dist[i] = INF;
        }
    }

    void addEdge(int u, int v, long weight) {
        adj[u].add(new Edge(v, weight));
    }

    // Run Dijkstra from source node
    void dijkstra(int source) {
        // TODO: Implement Dijkstra's algorithm
        // 1. Initialize dist[source] = 0
        // 2. Use priority queue to process nodes
        // 3. For each edge, relax if shorter path found
    }

    // Get shortest distance to node
    long getDist(int node) {
        return dist[node];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // TODO: Implement your test case here
        int n = sc.nextInt();  // number of nodes
        int m = sc.nextInt();  // number of edges
        int source = sc.nextInt();

        Dijkstra graph = new Dijkstra(n);

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            long w = sc.nextLong();
            graph.addEdge(u, v, w);
        }

        graph.dijkstra(source);

        for (int i = 1; i <= n; i++) {
            System.out.println("Distance to " + i + ": " +
                (graph.getDist(i) == INF ? "INF" : graph.getDist(i)));
        }

        sc.close();
    }
}
