package Graph.Trees;

import java.util.*;

/**
 * Algorithm: Lowest Common Ancestor (Binary Lifting)
 * Time Complexity: O(n log n) preprocessing, O(log n) per query
 * Space Complexity: O(n log n)
 * Use case: Find LCA of two nodes efficiently in trees
 */
public class LCABinaryLifting {

    static final int LOG = 20;  // log2(MAXN)

    List<Integer>[] adj;
    int[][] up;  // up[node][i] = 2^i-th ancestor of node
    int[] depth;
    int n;

    @SuppressWarnings("unchecked")
    public LCABinaryLifting(int n) {
        this.n = n;
        adj = new ArrayList[n + 1];
        up = new int[n + 1][LOG];
        depth = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }

    // DFS to preprocess binary lifting table
    void dfs(int node, int parent) {
        // TODO: Implement DFS for preprocessing
        // 1. Set depth[node] = depth[parent] + 1
        // 2. Set up[node][0] = parent
        // 3. Calculate up[node][i] using up[up[node][i-1]][i-1]
        // 4. Recursively process children
    }

    // Preprocess from root
    void preprocess(int root) {
        dfs(root, 0);
    }

    // Find k-th ancestor of node
    int kthAncestor(int node, int k) {
        // TODO: Implement using binary lifting
        return node;
    }

    // Find LCA of two nodes
    int lca(int u, int v) {
        // TODO: Implement LCA using binary lifting
        // 1. Make both nodes at same level
        // 2. If they're equal, return
        // 3. Binary search for LCA by lifting both nodes
        return 0;
    }

    // Distance between two nodes
    int distance(int u, int v) {
        int l = lca(u, v);
        return depth[u] + depth[v] - 2 * depth[l];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // TODO: Implement your test case here
        int n = sc.nextInt();  // number of nodes

        LCABinaryLifting tree = new LCABinaryLifting(n);

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
