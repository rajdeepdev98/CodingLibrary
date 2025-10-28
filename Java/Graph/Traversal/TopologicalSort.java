import java.util.*;

/**
 * Algorithm: Topological Sort (Kahn's Algorithm - BFS)
 * Time Complexity: O(V + E)
 * Space Complexity: O(V)
 * Use case: Sort DAG vertices in linear order, dependency resolution
 */
public class TopologicalSort {

    List<Integer>[] adj;
    int[] indegree;
    int n;

    @SuppressWarnings("unchecked")
    public TopologicalSort(int n) {
        this.n = n;
        adj = new ArrayList[n + 1];
        indegree = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    void addEdge(int u, int v) {
        adj[u].add(v);
        indegree[v]++;
    }

    // Run Kahn's algorithm for topological sort
    // Returns empty list if cycle exists
    List<Integer> topoSort() {
        // TODO: Implement Kahn's algorithm
        // 1. Find all nodes with indegree 0
        // 2. Add them to queue
        // 3. Process queue: remove node, decrease neighbors' indegree
        // 4. If neighbor's indegree becomes 0, add to queue
        // 5. If processed nodes < n, cycle exists
        return new ArrayList<>();
    }

    // Check if DAG (no cycle)
    boolean isDAG() {
        return topoSort().size() == n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // TODO: Implement your test case here
        int n = sc.nextInt();  // number of nodes
        int m = sc.nextInt();  // number of edges

        TopologicalSort graph = new TopologicalSort(n);

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.addEdge(u, v);
        }

        List<Integer> order = graph.topoSort();

        if (order.isEmpty()) {
            System.out.println("Cycle detected! Not a DAG.");
        } else {
            System.out.println("Topological Order: " + order);
        }

        sc.close();
    }
}
