package Graph.MST;

import java.util.*;

/**
 * Algorithm: Prim's Minimum Spanning Tree
 * Time Complexity: O((V + E) log V) with priority queue
 * Space Complexity: O(V + E)
 * Use case: Find MST in undirected weighted graphs, good for dense graphs
 */
public class PrimsMST {

    static final long INF = (long)1e18;

    static class Edge {
        int to;
        long weight;

        Edge(int to, long weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Node implements Comparable<Node> {
        int vertex;
        long weight;

        Node(int vertex, long weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other) {
            return Long.compare(this.weight, other.weight);
        }
    }

    List<Edge>[] adj;
    boolean[] inMST;
    int n;

    @SuppressWarnings("unchecked")
    public PrimsMST(int n) {
        this.n = n;
        adj = new ArrayList[n + 1];
        inMST = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    void addEdge(int u, int v, long weight) {
        adj[u].add(new Edge(v, weight));
        adj[v].add(new Edge(u, weight));
    }

    // Run Prim's algorithm starting from node 1
    // Returns MST weight
    long prims() {
        // TODO: Implement Prim's algorithm
        // 1. Start from any node (e.g., node 1)
        // 2. Use priority queue to select minimum weight edge
        // 3. Add edge if it connects to a new vertex
        // 4. Mark vertex as visited and add its edges to queue
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // TODO: Implement your test case here
        int n = sc.nextInt();  // number of nodes
        int m = sc.nextInt();  // number of edges

        PrimsMST mst = new PrimsMST(n);

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            long w = sc.nextLong();
            mst.addEdge(u, v, w);
        }

        long totalWeight = mst.prims();
        System.out.println("MST Weight: " + totalWeight);

        sc.close();
    }
}
