import java.util.*;

/**
 * Algorithm: Bipartite Graph Check and Operations
 * Time Complexity: O(V + E)
 * Space Complexity: O(V)
 * Use case: Check if graph is bipartite, find partition
 */
public class Bipartite {

    List<Integer>[] adj;
    int[] color;  // 0 = uncolored, 1 = color1, 2 = color2
    boolean isBipartite;
    int n;

    @SuppressWarnings("unchecked")
    public Bipartite(int n) {
        this.n = n;
        adj = new ArrayList[n + 1];
        color = new int[n + 1];
        isBipartite = true;

        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }

    // BFS to check bipartiteness and color vertices
    boolean bfs(int start) {
        // TODO: Implement BFS coloring
        // 1. Color start node with color 1
        // 2. Color neighbors with opposite color
        // 3. If neighbor has same color, not bipartite
        return true;
    }

    // DFS alternative for checking bipartiteness
    boolean dfs(int node, int c) {
        // TODO: Implement DFS coloring
        return true;
    }

    // Check if entire graph is bipartite
    boolean checkBipartite() {
        for (int i = 1; i <= n; i++) {
            if (color[i] == 0) {
                if (!bfs(i)) {
                    isBipartite = false;
                    return false;
                }
            }
        }
        return true;
    }

    // Get two partitions
    List<List<Integer>> getPartitions() {
        List<List<Integer>> partitions = new ArrayList<>();
        List<Integer> part1 = new ArrayList<>();
        List<Integer> part2 = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (color[i] == 1) part1.add(i);
            else if (color[i] == 2) part2.add(i);
        }

        partitions.add(part1);
        partitions.add(part2);
        return partitions;
    }

    // Check if graph has odd cycle (not bipartite iff has odd cycle)
    boolean hasOddCycle() {
        return !isBipartite;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // TODO: Implement your test case here
        int n = sc.nextInt();  // number of nodes
        int m = sc.nextInt();  // number of edges

        Bipartite graph = new Bipartite(n);

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.addEdge(u, v);
        }

        if (graph.checkBipartite()) {
            System.out.println("Graph is BIPARTITE");
            List<List<Integer>> parts = graph.getPartitions();
            System.out.println("Partition 1: " + parts.get(0));
            System.out.println("Partition 2: " + parts.get(1));
        } else {
            System.out.println("Graph is NOT BIPARTITE");
        }

        sc.close();
    }
}
