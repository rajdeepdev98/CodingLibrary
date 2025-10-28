import java.util.*;

/**
 * Algorithm: Topological Sort (DFS-based)
 * Time Complexity: O(V + E)
 * Space Complexity: O(V)
 * Use case: Sort DAG vertices using DFS, alternative to Kahn's algorithm
 */
public class TopologicalSortDFS {

    List<Integer>[] adj;
    boolean[] visited;
    boolean[] recStack;  // For cycle detection
    Stack<Integer> stack;
    int n;

    @SuppressWarnings("unchecked")
    public TopologicalSortDFS(int n) {
        this.n = n;
        adj = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        recStack = new boolean[n + 1];
        stack = new Stack<>();

        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    void addEdge(int u, int v) {
        adj[u].add(v);
    }

    // DFS helper for topological sort
    boolean dfs(int node) {
        // TODO: Implement DFS for topological sort
        // 1. Mark node as visited and add to recursion stack
        // 2. Visit all neighbors recursively
        // 3. If neighbor is in recStack, cycle detected
        // 4. Remove from recStack, push to stack
        // 5. Return false if cycle detected
        return true;
    }

    // Run topological sort using DFS
    // Returns empty list if cycle exists
    List<Integer> topoSort() {
        List<Integer> result = new ArrayList<>();

        // TODO: Run DFS on all unvisited nodes
        // If cycle detected, return empty list

        // Pop all elements from stack to get topological order
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // TODO: Implement your test case here
        int n = sc.nextInt();  // number of nodes
        int m = sc.nextInt();  // number of edges

        TopologicalSortDFS graph = new TopologicalSortDFS(n);

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
