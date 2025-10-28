import java.util.*;

/**
 * Algorithm: Bridges (Cut Edges)
 * Time Complexity: O(V + E)
 * Space Complexity: O(V)
 * Use case: Find edges whose removal increases number of connected components
 */
public class Bridges {

    static class Edge {
        int u, v;
        Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }

    List<Integer>[] adj;
    boolean[] visited;
    int[] disc;      // Discovery time
    int[] low;       // Lowest discovery time reachable
    int[] parent;
    List<Edge> bridges;
    int time;
    int n;

    @SuppressWarnings("unchecked")
    public Bridges(int n) {
        this.n = n;
        adj = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        disc = new int[n + 1];
        low = new int[n + 1];
        parent = new int[n + 1];
        bridges = new ArrayList<>();
        time = 0;

        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
            parent[i] = -1;
        }
    }

    void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }

    // DFS to find bridges
    void dfs(int node) {
        // TODO: Implement DFS for bridges
        // 1. Mark visited, set disc[node] = low[node] = time++
        // 2. For each neighbor:
        //    - If not visited: recurse, update low[node]
        //    - Check bridge condition: low[neighbor] > disc[node]
        //    - If visited and not parent: update low[node]
    }

    // Find all bridges
    List<Edge> findBridges() {
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }
        return bridges;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // TODO: Implement your test case here
        int n = sc.nextInt();  // number of nodes
        int m = sc.nextInt();  // number of edges

        Bridges graph = new Bridges(n);

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.addEdge(u, v);
        }

        List<Edge> bridges = graph.findBridges();
        System.out.println("Bridges:");
        for (Edge e : bridges) {
            System.out.println(e.u + " - " + e.v);
        }

        sc.close();
    }
}
