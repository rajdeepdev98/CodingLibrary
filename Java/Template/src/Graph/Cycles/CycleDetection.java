package Graph.Cycles;

import java.util.*;

/**
 * Algorithm: Cycle Detection
 * Time Complexity: O(V + E)
 * Space Complexity: O(V)
 * Use case: Detect cycles in directed/undirected graphs
 */
public class CycleDetection {

    List<Integer>[] adj;
    boolean[] visited;
    boolean[] recStack;  // For directed graphs
    int[] parent;        // For undirected graphs
    boolean directed;
    int n;

    @SuppressWarnings("unchecked")
    public CycleDetection(int n, boolean directed) {
        this.n = n;
        this.directed = directed;
        adj = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        recStack = new boolean[n + 1];
        parent = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
            parent[i] = -1;
        }
    }

    void addEdge(int u, int v) {
        adj[u].add(v);
        if (!directed) {
            adj[v].add(u);
        }
    }

    // DFS for directed graph cycle detection
    boolean dfsDirected(int node) {
        // TODO: Implement DFS for directed graph
        // Use recursion stack to detect back edges
        return false;
    }

    // DFS for undirected graph cycle detection
    boolean dfsUndirected(int node, int par) {
        // TODO: Implement DFS for undirected graph
        // If visited neighbor is not parent, cycle exists
        return false;
    }

    // Check if graph has cycle
    boolean hasCycle() {
        // TODO: Implement cycle detection
        // Call appropriate DFS based on graph type
        return false;
    }

    // Get one cycle (if exists)
    List<Integer> getCycle() {
        // TODO: Implement cycle extraction
        // Track path during DFS and return cycle when found
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // TODO: Implement your test case here
        int n = sc.nextInt();  // number of nodes
        int m = sc.nextInt();  // number of edges
        boolean directed = sc.nextInt() == 1;

        CycleDetection graph = new CycleDetection(n, directed);

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.addEdge(u, v);
        }

        System.out.println("Has cycle: " + graph.hasCycle());

        sc.close();
    }
}
