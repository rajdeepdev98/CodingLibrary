package Graph.Trees;

import java.util.*;

/**
 * Algorithm: Lowest Common Ancestor (Euler Tour + RMQ)
 * Time Complexity: O(n) preprocessing, O(1) per query with sparse table
 * Space Complexity: O(n log n)
 * Use case: Alternative LCA method using Euler tour and range minimum query
 */
public class LCAEulerTour {

    List<Integer>[] adj;
    int[] euler;     // Euler tour sequence
    int[] first;     // First occurrence of node in euler tour
    int[] depth;     // Depth of each node
    int[][] sparse;  // Sparse table for RMQ
    int eulerIdx;
    int n;

    @SuppressWarnings("unchecked")
    public LCAEulerTour(int n) {
        this.n = n;
        adj = new ArrayList[n + 1];
        euler = new int[2 * n];
        first = new int[n + 1];
        depth = new int[n + 1];
        eulerIdx = 0;

        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
            first[i] = -1;
        }
    }

    void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }

    // DFS to build Euler tour
    void dfs(int node, int parent, int d) {
        // TODO: Implement DFS for Euler tour
        // 1. Record first occurrence of node
        // 2. Add node to euler tour
        // 3. Set depth
        // 4. Visit children and add node again after each child
    }

    // Build sparse table for RMQ
    void buildSparseTable() {
        // TODO: Implement sparse table construction
        // For range minimum query on euler tour (by depth)
    }

    // Preprocess from root
    void preprocess(int root) {
        dfs(root, 0, 0);
        buildSparseTable();
    }

    // Range minimum query on euler tour
    int rmq(int l, int r) {
        // TODO: Implement RMQ using sparse table
        return 0;
    }

    // Find LCA of two nodes
    int lca(int u, int v) {
        // TODO: Implement LCA
        // 1. Get first occurrences of u and v in euler tour
        // 2. Find node with minimum depth in range [first[u], first[v]]
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // TODO: Implement your test case here
        int n = sc.nextInt();  // number of nodes

        LCAEulerTour tree = new LCAEulerTour(n);

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            tree.addEdge(u, v);
        }

        tree.preprocess(1);  // Root at node 1

        int q = sc.nextInt();  // number of queries
        for (int i = 0; i < q; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            System.out.println("LCA(" + u + ", " + v + ") = " + tree.lca(u, v));
        }

        sc.close();
    }
}
