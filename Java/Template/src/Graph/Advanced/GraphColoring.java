package Graph.Advanced;

import java.util.*;

/**
 * Algorithm: Graph Coloring
 * Time Complexity: O(V * C^V) for backtracking, various for heuristics
 * Space Complexity: O(V)
 * Use case: Color graph with minimum colors such that no adjacent vertices share color
 */
public class GraphColoring {

    List<Integer>[] adj;
    int[] color;
    int n;

    @SuppressWarnings("unchecked")
    public GraphColoring(int n) {
        this.n = n;
        adj = new ArrayList[n + 1];
        color = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
            color[i] = -1;
        }
    }

    void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }

    // Check if color is safe for vertex
    boolean isSafe(int node, int c) {
        for (int neighbor : adj[node]) {
            if (color[neighbor] == c) {
                return false;
            }
        }
        return true;
    }

    // Backtracking to find coloring with k colors
    boolean graphColoringUtil(int node, int k) {
        // TODO: Implement backtracking
        // Try all colors for current node
        // Recurse for next node
        return false;
    }

    // Find if graph can be colored with k colors
    boolean canColorWithK(int k) {
        Arrays.fill(color, -1);
        return graphColoringUtil(1, k);
    }

    // Find chromatic number (minimum colors needed)
    int chromaticNumber() {
        // TODO: Binary search or try k = 1, 2, 3, ...
        // Return minimum k for which graph can be colored
        return 0;
    }

    // Greedy coloring (may not be optimal but fast)
    int greedyColoring() {
        // TODO: Implement greedy coloring
        // Process vertices in order, assign smallest available color
        return 0;
    }

    // Welsh-Powell algorithm (greedy with degree ordering)
    int welshPowell() {
        // TODO: Implement Welsh-Powell
        // 1. Sort vertices by degree (descending)
        // 2. Apply greedy coloring
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // TODO: Implement your test case here
        int n = sc.nextInt();  // number of nodes
        int m = sc.nextInt();  // number of edges

        GraphColoring graph = new GraphColoring(n);

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.addEdge(u, v);
        }

        int minColors = graph.greedyColoring();
        System.out.println("Colors used (greedy): " + minColors);

        for (int i = 1; i <= n; i++) {
            System.out.println("Node " + i + " -> Color " + graph.color[i]);
        }

        sc.close();
    }
}
