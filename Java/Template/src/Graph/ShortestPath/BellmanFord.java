package Graph.ShortestPath;

import java.util.*;

/**
 * Algorithm: Bellman-Ford Shortest Path
 * Time Complexity: O(V * E)
 * Space Complexity: O(V)
 * Use case: Single-source shortest path, works with negative weights, detects negative cycles
 */
public class BellmanFord {

    static final long INF = (long)1e18;

    static class Edge {
        int from, to;
        long weight;

        Edge(int from, int to, long weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    List<Edge> edges;
    long[] dist;
    int n;

    public BellmanFord(int n) {
        this.n = n;
        edges = new ArrayList<>();
        dist = new long[n + 1];
        Arrays.fill(dist, INF);
    }

    void addEdge(int u, int v, long weight) {
        edges.add(new Edge(u, v, weight));
    }

    // Run Bellman-Ford from source node
    // Returns true if no negative cycle, false otherwise
    boolean bellmanFord(int source) {
        // TODO: Implement Bellman-Ford algorithm
        // 1. Initialize dist[source] = 0
        // 2. Relax all edges V-1 times
        // 3. Check for negative cycles in Vth iteration
        return true;
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

        BellmanFord graph = new BellmanFord(n);

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            long w = sc.nextLong();
            graph.addEdge(u, v, w);
        }

        boolean noNegCycle = graph.bellmanFord(source);

        if (!noNegCycle) {
            System.out.println("Negative cycle detected!");
        } else {
            for (int i = 1; i <= n; i++) {
                System.out.println("Distance to " + i + ": " +
                    (graph.getDist(i) == INF ? "INF" : graph.getDist(i)));
            }
        }

        sc.close();
    }
}
