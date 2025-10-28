import java.util.*;

/**
 * Algorithm: Basic Graph Template (Unweighted)
 * Time Complexity: O(V + E) for most operations
 * Space Complexity: O(V + E)
 * Use case: Foundation for all graph algorithms using adjacency list
 */
public class GraphTemplate {

    // Constants
    static final int MAXN = 100005;

    // Data structures
    List<Integer>[] adj;
    int n;  // number of nodes
    boolean directed;

    // Constructor
    @SuppressWarnings("unchecked")
    public GraphTemplate(int n, boolean directed) {
        this.n = n;
        this.directed = directed;
        adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    // Add edge method
    void addEdge(int u, int v) {
        adj[u].add(v);
        if (!directed) {
            adj[v].add(u);
        }
    }

    // Get neighbors
    List<Integer> getNeighbors(int u) {
        return adj[u];
    }

    // Print graph
    void printGraph() {
        for (int i = 1; i <= n; i++) {
            System.out.print(i + " -> ");
            for (int v : adj[i]) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }

    // Main method with test case
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // TODO: Implement your test case here
        int n = sc.nextInt();  // number of nodes
        int m = sc.nextInt();  // number of edges

        GraphTemplate graph = new GraphTemplate(n, false);

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.addEdge(u, v);
        }

        graph.printGraph();

        sc.close();
    }
}
