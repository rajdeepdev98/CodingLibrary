import java.util.*;

/**
 * Algorithm: Articulation Points (Cut Vertices)
 * Time Complexity: O(V + E)
 * Space Complexity: O(V)
 * Use case: Find vertices whose removal increases number of connected components
 */
public class ArticulationPoints {

    List<Integer>[] adj;
    boolean[] visited;
    int[] disc;      // Discovery time
    int[] low;       // Lowest discovery time reachable
    int[] parent;
    boolean[] isAP;  // Is articulation point
    int time;
    int n;

    @SuppressWarnings("unchecked")
    public ArticulationPoints(int n) {
        this.n = n;
        adj = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        disc = new int[n + 1];
        low = new int[n + 1];
        parent = new int[n + 1];
        isAP = new boolean[n + 1];
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

    // DFS to find articulation points
    void dfs(int node) {
        // TODO: Implement DFS for articulation points
        // 1. Mark visited, set disc[node] = low[node] = time++
        // 2. For each neighbor:
        //    - If not visited: recurse, update low[node]
        //    - Check articulation point conditions
        //    - If visited and not parent: update low[node]
        // 3. Root is AP if it has more than one child
        // 4. Non-root is AP if low[child] >= disc[node]
    }

    // Find all articulation points
    List<Integer> findArticulationPoints() {
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }

        for (int i = 1; i <= n; i++) {
            if (isAP[i]) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // TODO: Implement your test case here
        int n = sc.nextInt();  // number of nodes
        int m = sc.nextInt();  // number of edges

        ArticulationPoints graph = new ArticulationPoints(n);

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.addEdge(u, v);
        }

        List<Integer> aps = graph.findArticulationPoints();
        System.out.println("Articulation Points: " + aps);

        sc.close();
    }
}
