package Graph.Flow;

import java.util.*;

/**
 * Algorithm: Bipartite Matching (Hopcroft-Karp / Kuhn's Algorithm)
 * Time Complexity: O(E * sqrt(V)) with Hopcroft-Karp
 * Space Complexity: O(V + E)
 * Use case: Maximum matching in bipartite graphs
 */
public class BipartiteMatching {

    List<Integer>[] adj;
    int[] match;     // match[v] = u means v is matched to u
    boolean[] visited;
    int n, m;        // n = left side, m = right side

    @SuppressWarnings("unchecked")
    public BipartiteMatching(int n, int m) {
        this.n = n;
        this.m = m;
        adj = new ArrayList[n + 1];
        match = new int[m + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        Arrays.fill(match, -1);
    }

    // Add edge from left node u to right node v
    void addEdge(int u, int v) {
        adj[u].add(v);
    }

    // DFS to find augmenting path (Kuhn's algorithm)
    boolean dfs(int node) {
        // TODO: Implement DFS for augmenting path
        // Try to match node with an unmatched vertex or
        // find augmenting path through matched vertices
        return false;
    }

    // Find maximum matching
    int maxMatching() {
        // TODO: Implement maximum matching
        // For each left vertex, try to find augmenting path
        return 0;
    }

    // Get matching as pairs
    List<int[]> getMatching() {
        List<int[]> matching = new ArrayList<>();
        for (int v = 1; v <= m; v++) {
            if (match[v] != -1) {
                matching.add(new int[]{match[v], v});
            }
        }
        return matching;
    }

    // Alternative: Check if graph is bipartite using BFS coloring
    static boolean isBipartite(List<Integer>[] graph, int n) {
        // TODO: Implement bipartite check
        // Use BFS/DFS to color graph with 2 colors
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // TODO: Implement your test case here
        int n = sc.nextInt();  // left side nodes
        int m = sc.nextInt();  // right side nodes
        int edges = sc.nextInt();

        BipartiteMatching matching = new BipartiteMatching(n, m);

        for (int i = 0; i < edges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            matching.addEdge(u, v);
        }

        int maxMatch = matching.maxMatching();
        System.out.println("Maximum Matching: " + maxMatch);

        List<int[]> pairs = matching.getMatching();
        System.out.println("Matched pairs:");
        for (int[] pair : pairs) {
            System.out.println(pair[0] + " - " + pair[1]);
        }

        sc.close();
    }
}
