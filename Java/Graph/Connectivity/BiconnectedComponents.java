import java.util.*;

/**
 * Algorithm: Biconnected Components
 * Time Complexity: O(V + E)
 * Space Complexity: O(V + E)
 * Use case: Find maximal biconnected subgraphs (no articulation points within)
 */
public class BiconnectedComponents {

    static class Edge {
        int u, v;
        Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }
        @Override
        public String toString() {
            return "(" + u + "," + v + ")";
        }
    }

    List<Integer>[] adj;
    boolean[] visited;
    int[] disc;
    int[] low;
    int[] parent;
    Stack<Edge> edgeStack;
    List<List<Edge>> components;
    int time;
    int n;

    @SuppressWarnings("unchecked")
    public BiconnectedComponents(int n) {
        this.n = n;
        adj = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        disc = new int[n + 1];
        low = new int[n + 1];
        parent = new int[n + 1];
        edgeStack = new Stack<>();
        components = new ArrayList<>();
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

    // DFS to find biconnected components
    void dfs(int node) {
        // TODO: Implement DFS for biconnected components
        // 1. Set disc[node] = low[node] = time++
        // 2. For each neighbor:
        //    - Push edge to stack
        //    - If not visited: recurse
        //    - Check if subtree forms a biconnected component
        //    - When low[child] >= disc[node], pop edges from stack
    }

    // Find all biconnected components
    List<List<Edge>> findBiconnectedComponents() {
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
                // Handle remaining edges in stack for this component
                if (!edgeStack.isEmpty()) {
                    List<Edge> comp = new ArrayList<>();
                    while (!edgeStack.isEmpty()) {
                        comp.add(edgeStack.pop());
                    }
                    components.add(comp);
                }
            }
        }
        return components;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // TODO: Implement your test case here
        int n = sc.nextInt();  // number of nodes
        int m = sc.nextInt();  // number of edges

        BiconnectedComponents graph = new BiconnectedComponents(n);

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.addEdge(u, v);
        }

        List<List<Edge>> components = graph.findBiconnectedComponents();

        System.out.println("Number of Biconnected Components: " + components.size());
        for (int i = 0; i < components.size(); i++) {
            System.out.println("Component " + (i + 1) + ": " + components.get(i));
        }

        sc.close();
    }
}
