package Graph.Trees;

import java.util.*;

/**
 * Algorithm: Centroid Decomposition
 * Time Complexity: O(n log n) preprocessing, O(log n) per query
 * Space Complexity: O(n)
 * Use case: Divide-and-conquer on trees, path queries
 */
public class Centroid {

    List<Integer>[] adj;
    boolean[] removed;
    int[] subtreeSize;
    int[] parent;  // Parent in centroid tree
    int n;

    @SuppressWarnings("unchecked")
    public Centroid(int n) {
        this.n = n;
        adj = new ArrayList[n + 1];
        removed = new boolean[n + 1];
        subtreeSize = new int[n + 1];
        parent = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }

    // Calculate subtree size
    int dfs(int node, int par) {
        // TODO: Implement subtree size calculation
        return 0;
    }

    // Find centroid of current tree
    int findCentroid(int node, int par, int treeSize) {
        // TODO: Implement centroid finding
        // Centroid is node where all subtrees have size <= treeSize/2
        return node;
    }

    // Decompose tree recursively
    int decompose(int node, int par) {
        // TODO: Implement centroid decomposition
        // 1. Find centroid of current tree
        // 2. Mark centroid as removed
        // 3. Recursively decompose each subtree
        // 4. Set parent in centroid tree
        return node;
    }

    // Preprocess - build centroid tree
    void preprocess() {
        decompose(1, 0);
    }

    // Example: Update node in centroid tree
    void update(int node, int value) {
        // TODO: Implement update
        // Walk up centroid tree and update ancestors
    }

    // Example: Query distance-based operation
    int query(int node) {
        // TODO: Implement query
        // Walk up centroid tree and combine results
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // TODO: Implement your test case here
        int n = sc.nextInt();  // number of nodes

        Centroid tree = new Centroid(n);

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            tree.addEdge(u, v);
        }

        tree.preprocess();

        sc.close();
    }
}
