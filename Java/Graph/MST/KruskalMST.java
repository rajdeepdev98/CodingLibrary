import java.util.*;

/**
 * Algorithm: Kruskal's Minimum Spanning Tree
 * Time Complexity: O(E log E) for sorting edges
 * Space Complexity: O(V + E)
 * Use case: Find MST in undirected weighted graphs, uses DSU
 */
public class KruskalMST {

    static class Edge implements Comparable<Edge> {
        int u, v;
        long weight;

        Edge(int u, int v, long weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return Long.compare(this.weight, other.weight);
        }
    }

    // Disjoint Set Union (DSU)
    static class DSU {
        int[] parent, rank;

        DSU(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        int find(int x) {
            // TODO: Implement find with path compression
            return x;
        }

        boolean union(int x, int y) {
            // TODO: Implement union by rank
            // Return true if union successful, false if already in same set
            return true;
        }
    }

    List<Edge> edges;
    int n;

    public KruskalMST(int n) {
        this.n = n;
        edges = new ArrayList<>();
    }

    void addEdge(int u, int v, long weight) {
        edges.add(new Edge(u, v, weight));
    }

    // Run Kruskal's algorithm
    // Returns MST weight and stores MST edges in result list
    long kruskal(List<Edge> mstEdges) {
        // TODO: Implement Kruskal's algorithm
        // 1. Sort edges by weight
        // 2. Use DSU to avoid cycles
        // 3. Add edge if it connects different components
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // TODO: Implement your test case here
        int n = sc.nextInt();  // number of nodes
        int m = sc.nextInt();  // number of edges

        KruskalMST mst = new KruskalMST(n);

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            long w = sc.nextLong();
            mst.addEdge(u, v, w);
        }

        List<Edge> mstEdges = new ArrayList<>();
        long totalWeight = mst.kruskal(mstEdges);

        System.out.println("MST Weight: " + totalWeight);
        System.out.println("MST Edges:");
        for (Edge e : mstEdges) {
            System.out.println(e.u + " - " + e.v + " : " + e.weight);
        }

        sc.close();
    }
}
