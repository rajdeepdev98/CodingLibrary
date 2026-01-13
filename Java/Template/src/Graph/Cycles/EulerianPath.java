package Graph.Cycles;

import java.util.*;

/**
 * Algorithm: Eulerian Path/Circuit
 * Time Complexity: O(E)
 * Space Complexity: O(V + E)
 * Use case: Find path visiting each edge exactly once
 */
public class EulerianPath {

    List<Integer>[] adj;
    int[] inDegree, outDegree;
    boolean directed;
    int n, m;

    @SuppressWarnings("unchecked")
    public EulerianPath(int n, boolean directed) {
        this.n = n;
        this.directed = directed;
        adj = new ArrayList[n + 1];
        inDegree = new int[n + 1];
        outDegree = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    void addEdge(int u, int v) {
        adj[u].add(v);
        outDegree[u]++;
        inDegree[v]++;

        if (!directed) {
            adj[v].add(u);
            outDegree[v]++;
            inDegree[u]++;
        }
        m++;
    }

    // Check if Eulerian circuit exists
    boolean hasEulerianCircuit() {
        // TODO: Implement check
        // Undirected: all vertices have even degree
        // Directed: all vertices have equal in-degree and out-degree
        return false;
    }

    // Check if Eulerian path exists
    boolean hasEulerianPath() {
        // TODO: Implement check
        // Undirected: exactly 0 or 2 vertices with odd degree
        // Directed: at most one vertex with out-in = 1, one with in-out = 1
        return false;
    }

    // Find Eulerian path/circuit using Hierholzer's algorithm
    List<Integer> findEulerianPath() {
        // TODO: Implement Hierholzer's algorithm
        // 1. Start from appropriate vertex
        // 2. Use stack to track current path
        // 3. Follow edges, removing them as visited
        // 4. Build path in reverse
        return new ArrayList<>();
    }

    // Get start vertex for Eulerian path
    int getStartVertex() {
        // TODO: Find appropriate start vertex
        // For circuit: any vertex with edges
        // For path: vertex with odd degree (undirected) or out-in = 1 (directed)
        return 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // TODO: Implement your test case here
        int n = sc.nextInt();  // number of nodes
        int m = sc.nextInt();  // number of edges
        boolean directed = sc.nextInt() == 1;

        EulerianPath graph = new EulerianPath(n, directed);

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.addEdge(u, v);
        }

        if (graph.hasEulerianCircuit()) {
            System.out.println("Has Eulerian Circuit");
        } else if (graph.hasEulerianPath()) {
            System.out.println("Has Eulerian Path");
        } else {
            System.out.println("No Eulerian Path or Circuit");
        }

        List<Integer> path = graph.findEulerianPath();
        System.out.println("Path: " + path);

        sc.close();
    }
}
