import java.util.*;

/**
 * Algorithm: Strongly Connected Components (Kosaraju's/Tarjan's)
 * Time Complexity: O(V + E)
 * Space Complexity: O(V)
 * Use case: Find SCCs in directed graphs
 */
public class StronglyConnectedComponents {

    List<Integer>[] adj, radj;  // Original and reversed graph
    boolean[] visited;
    Stack<Integer> stack;
    int[] component;  // Component ID for each node
    int numComponents;
    int n;

    @SuppressWarnings("unchecked")
    public StronglyConnectedComponents(int n) {
        this.n = n;
        adj = new ArrayList[n + 1];
        radj = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        stack = new Stack<>();
        component = new int[n + 1];
        numComponents = 0;

        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
            radj[i] = new ArrayList<>();
        }
    }

    void addEdge(int u, int v) {
        adj[u].add(v);
        radj[v].add(u);  // Reversed edge
    }

    // First DFS to fill stack by finish time
    void dfs1(int node) {
        // TODO: Implement first DFS
        // Visit all neighbors, then push to stack
    }

    // Second DFS on reversed graph
    void dfs2(int node, int comp) {
        // TODO: Implement second DFS
        // Assign component ID to all reachable nodes
    }

    // Find SCCs using Kosaraju's algorithm
    void findSCCs() {
        // TODO: Implement Kosaraju's algorithm
        // 1. First DFS pass: fill stack by finish time
        // 2. Second DFS pass on reversed graph in stack order
    }

    // Alternative: Tarjan's algorithm (single pass)
    void tarjan() {
        // TODO: Implement Tarjan's algorithm
        // Uses disc[], low[], and stack for single-pass SCC finding
    }

    // Get all SCCs as list of lists
    List<List<Integer>> getSCCs() {
        Map<Integer, List<Integer>> compMap = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            compMap.computeIfAbsent(component[i], k -> new ArrayList<>()).add(i);
        }
        return new ArrayList<>(compMap.values());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // TODO: Implement your test case here
        int n = sc.nextInt();  // number of nodes
        int m = sc.nextInt();  // number of edges

        StronglyConnectedComponents graph = new StronglyConnectedComponents(n);

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.addEdge(u, v);
        }

        graph.findSCCs();

        System.out.println("Number of SCCs: " + graph.numComponents);
        List<List<Integer>> sccs = graph.getSCCs();
        for (int i = 0; i < sccs.size(); i++) {
            System.out.println("SCC " + (i + 1) + ": " + sccs.get(i));
        }

        sc.close();
    }
}
