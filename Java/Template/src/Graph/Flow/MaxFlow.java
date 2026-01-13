package Graph.Flow;

import java.util.*;

/**
 * Algorithm: Maximum Flow (Dinic's Algorithm)
 * Time Complexity: O(V^2 * E)
 * Space Complexity: O(V + E)
 * Use case: Find maximum flow from source to sink in flow network
 */
public class MaxFlow {

    static final long INF = (long)1e18;

    static class Edge {
        int to, rev;
        long cap;

        Edge(int to, long cap, int rev) {
            this.to = to;
            this.cap = cap;
            this.rev = rev;
        }
    }

    List<Edge>[] adj;
    int[] level;
    int[] iter;
    int n;

    @SuppressWarnings("unchecked")
    public MaxFlow(int n) {
        this.n = n;
        adj = new ArrayList[n + 1];
        level = new int[n + 1];
        iter = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    // Add edge with capacity
    void addEdge(int u, int v, long cap) {
        adj[u].add(new Edge(v, cap, adj[v].size()));
        adj[v].add(new Edge(u, 0, adj[u].size() - 1));  // Reverse edge
    }

    // BFS to construct level graph
    boolean bfs(int source, int sink) {
        // TODO: Implement BFS
        // Construct level graph, return true if sink is reachable
        return false;
    }

    // DFS to find blocking flow
    long dfs(int node, int sink, long flow) {
        // TODO: Implement DFS
        // Find augmenting path and push flow
        return 0;
    }

    // Run Dinic's algorithm
    long maxFlow(int source, int sink) {
        // TODO: Implement Dinic's algorithm
        // 1. Build level graph using BFS
        // 2. Find blocking flow using DFS
        // 3. Repeat until sink is not reachable
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // TODO: Implement your test case here
        int n = sc.nextInt();  // number of nodes
        int m = sc.nextInt();  // number of edges
        int source = sc.nextInt();
        int sink = sc.nextInt();

        MaxFlow flow = new MaxFlow(n);

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            long cap = sc.nextLong();
            flow.addEdge(u, v, cap);
        }

        System.out.println("Maximum Flow: " + flow.maxFlow(source, sink));

        sc.close();
    }
}
