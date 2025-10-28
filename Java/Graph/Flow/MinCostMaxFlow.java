import java.util.*;

/**
 * Algorithm: Minimum Cost Maximum Flow
 * Time Complexity: O(V * E * flow) with SPFA
 * Space Complexity: O(V + E)
 * Use case: Find maximum flow with minimum cost
 */
public class MinCostMaxFlow {

    static final long INF = (long)1e18;

    static class Edge {
        int to, rev;
        long cap, cost;

        Edge(int to, long cap, long cost, int rev) {
            this.to = to;
            this.cap = cap;
            this.cost = cost;
            this.rev = rev;
        }
    }

    List<Edge>[] adj;
    long[] dist;
    int[] parent;
    int[] parentEdge;
    boolean[] inQueue;
    int n;

    @SuppressWarnings("unchecked")
    public MinCostMaxFlow(int n) {
        this.n = n;
        adj = new ArrayList[n + 1];
        dist = new long[n + 1];
        parent = new int[n + 1];
        parentEdge = new int[n + 1];
        inQueue = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    // Add edge with capacity and cost
    void addEdge(int u, int v, long cap, long cost) {
        adj[u].add(new Edge(v, cap, cost, adj[v].size()));
        adj[v].add(new Edge(u, 0, -cost, adj[u].size() - 1));  // Reverse edge
    }

    // SPFA to find shortest path with available capacity
    boolean spfa(int source, int sink) {
        // TODO: Implement SPFA (Shortest Path Faster Algorithm)
        // Find path with minimum cost and available capacity
        return false;
    }

    // Run min cost max flow algorithm
    long[] minCostMaxFlow(int source, int sink) {
        // TODO: Implement min cost max flow
        // 1. Use SPFA to find shortest augmenting path
        // 2. Push maximum possible flow through path
        // 3. Update costs
        // 4. Repeat until no augmenting path exists
        // Return {maxFlow, minCost}
        return new long[]{0, 0};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // TODO: Implement your test case here
        int n = sc.nextInt();  // number of nodes
        int m = sc.nextInt();  // number of edges
        int source = sc.nextInt();
        int sink = sc.nextInt();

        MinCostMaxFlow flow = new MinCostMaxFlow(n);

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            long cap = sc.nextLong();
            long cost = sc.nextLong();
            flow.addEdge(u, v, cap, cost);
        }

        long[] result = flow.minCostMaxFlow(source, sink);
        System.out.println("Maximum Flow: " + result[0]);
        System.out.println("Minimum Cost: " + result[1]);

        sc.close();
    }
}
