import java.util.*;

/**
 * Algorithm: Heavy-Light Decomposition (Edge Variant)
 * Time Complexity: O(log^2 n) per query
 * Space Complexity: O(n)
 * Use case: HLD for edge queries/updates instead of node queries
 */
public class HLDEdge {

    static class Edge {
        int to, id;
        Edge(int to, int id) {
            this.to = to;
            this.id = id;
        }
    }

    List<Edge>[] adj;
    int[] parent, depth, heavy, head, pos;
    int[] subtreeSize;
    int[] edgePos;  // Position of edge in flattened array
    int currentPos;
    int n;

    @SuppressWarnings("unchecked")
    public HLDEdge(int n) {
        this.n = n;
        adj = new ArrayList[n + 1];
        parent = new int[n + 1];
        depth = new int[n + 1];
        heavy = new int[n + 1];
        head = new int[n + 1];
        pos = new int[n + 1];
        subtreeSize = new int[n + 1];
        edgePos = new int[n];  // n-1 edges
        currentPos = 0;

        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
            heavy[i] = -1;
        }
    }

    void addEdge(int u, int v, int edgeId) {
        adj[u].add(new Edge(v, edgeId));
        adj[v].add(new Edge(u, edgeId));
    }

    // DFS to calculate subtree sizes and find heavy children
    int dfs(int node, int par) {
        // TODO: Implement DFS
        // Similar to node HLD but track edges
        return 0;
    }

    // Decompose tree into heavy paths
    void decompose(int node, int par, int h, int edgeId) {
        // TODO: Implement decomposition
        // Assign position to edges instead of nodes
    }

    // Preprocess from root
    void preprocess(int root) {
        dfs(root, 0);
        decompose(root, 0, root, -1);
    }

    // Query on path edges from u to v
    int queryPath(int u, int v) {
        // TODO: Implement edge path query
        return 0;
    }

    // Update on path edges from u to v
    void updatePath(int u, int v, int value) {
        // TODO: Implement edge path update
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // TODO: Implement your test case here
        int n = sc.nextInt();  // number of nodes

        HLDEdge hld = new HLDEdge(n);

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            hld.addEdge(u, v, i);
        }

        hld.preprocess(1);  // Root at node 1

        sc.close();
    }
}
