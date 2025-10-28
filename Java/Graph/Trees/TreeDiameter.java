import java.util.*;

/**
 * Algorithm: Tree Diameter
 * Time Complexity: O(V)
 * Space Complexity: O(V)
 * Use case: Find longest path in a tree (two DFS/BFS approach)
 */
public class TreeDiameter {

    List<Integer>[] adj;
    int[] dist;
    int n;

    @SuppressWarnings("unchecked")
    public TreeDiameter(int n) {
        this.n = n;
        adj = new ArrayList[n + 1];
        dist = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }

    // BFS to find farthest node from given node
    int[] bfs(int source) {
        // TODO: Implement BFS
        // Return {farthest node, distance to farthest node}
        return new int[]{-1, -1};
    }

    // Calculate tree diameter
    int diameter() {
        // TODO: Implement diameter calculation
        // 1. Run BFS from any node (e.g., node 1) to find farthest node u
        // 2. Run BFS from u to find farthest node v and distance
        // 3. Distance from u to v is the diameter
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // TODO: Implement your test case here
        int n = sc.nextInt();  // number of nodes

        TreeDiameter tree = new TreeDiameter(n);

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            tree.addEdge(u, v);
        }

        System.out.println("Tree Diameter: " + tree.diameter());

        sc.close();
    }
}
