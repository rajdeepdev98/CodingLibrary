import java.util.*;

/**
 * Algorithm: 0-1 BFS
 * Time Complexity: O(V + E)
 * Space Complexity: O(V)
 * Use case: Shortest path in graphs with edge weights 0 or 1 only
 */
public class ZeroOneBFS {

    static final int INF = (int)1e9;

    static class Edge {
        int to, weight;  // weight should be 0 or 1

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    List<Edge>[] adj;
    int[] dist;
    int n;

    @SuppressWarnings("unchecked")
    public ZeroOneBFS(int n) {
        this.n = n;
        adj = new ArrayList[n + 1];
        dist = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
            dist[i] = INF;
        }
    }

    void addEdge(int u, int v, int weight) {
        // weight should be 0 or 1
        adj[u].add(new Edge(v, weight));
    }

    // Run 0-1 BFS from source node
    void zeroOneBFS(int source) {
        // TODO: Implement 0-1 BFS algorithm
        // 1. Use deque instead of priority queue
        // 2. If edge weight = 0, add to front of deque
        // 3. If edge weight = 1, add to back of deque
    }

    // Get shortest distance to node
    int getDist(int node) {
        return dist[node];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // TODO: Implement your test case here
        int n = sc.nextInt();  // number of nodes
        int m = sc.nextInt();  // number of edges
        int source = sc.nextInt();

        ZeroOneBFS graph = new ZeroOneBFS(n);

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();  // 0 or 1
            graph.addEdge(u, v, w);
        }

        graph.zeroOneBFS(source);

        for (int i = 1; i <= n; i++) {
            System.out.println("Distance to " + i + ": " +
                (graph.getDist(i) == INF ? "INF" : graph.getDist(i)));
        }

        sc.close();
    }
}
