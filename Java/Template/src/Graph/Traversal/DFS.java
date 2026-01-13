package Graph.Traversal;

import java.util.*;

/**
 * Algorithm: Depth-First Search (DFS)
 * Time Complexity: O(V + E)
 * Space Complexity: O(V)
 * Use case: Graph traversal, connectivity, cycle detection, topological sort
 */
public class DFS {

    List<Integer>[] adj;
    boolean[] visited;
    int[] parent;
    int[] discoveryTime;
    int[] finishTime;
    int time;
    int n;

    @SuppressWarnings("unchecked")
    public DFS(int n) {
        this.n = n;
        adj = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        parent = new int[n + 1];
        discoveryTime = new int[n + 1];
        finishTime = new int[n + 1];
        time = 0;

        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
            parent[i] = -1;
        }
    }

    void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);  // For undirected graph
    }

    // Run DFS from source node
    void dfs(int source) {
        // TODO: Implement DFS algorithm
        // 1. Mark node as visited
        // 2. Record discovery time
        // 3. Mark source as the parent of neighbour
        // 4. Recursively visit all unvisited neighbors
        // 5. Record finish time
        visited[source] = true;
        discoveryTime[source] = time++;
        for (int el : adj[source]){

            if(!visited[el]){
                parent[el] = source;
                dfs(el);
            }
        }
        finishTime[source] = time++;
    }

    // Run DFS on entire graph (handles disconnected components)
    void dfsAll() {
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

    // Check if graph is connected
    boolean isConnected() {
        dfs(1);
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // TODO: Implement your test case here
        int n = sc.nextInt();  // number of nodes
        int m = sc.nextInt();  // number of edges

        DFS graph = new DFS(n);

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.addEdge(u, v);
        }

        graph.dfsAll();

        System.out.println("DFS traversal completed");
        System.out.println("Is connected: " + graph.isConnected());

        sc.close();
    }
}
