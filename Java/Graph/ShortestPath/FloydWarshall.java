import java.util.*;

/**
 * Algorithm: Floyd-Warshall All-Pairs Shortest Path
 * Time Complexity: O(V^3)
 * Space Complexity: O(V^2)
 * Use case: All-pairs shortest path, works with negative weights (no negative cycles)
 */
public class FloydWarshall {

    static final long INF = (long)1e18;

    long[][] dist;
    int n;

    public FloydWarshall(int n) {
        this.n = n;
        dist = new long[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
    }

    void addEdge(int u, int v, long weight) {
        dist[u][v] = Math.min(dist[u][v], weight);
    }

    // Run Floyd-Warshall algorithm
    void floydWarshall() {
        // TODO: Implement Floyd-Warshall algorithm
        // Triple nested loop: k (intermediate), i (source), j (destination)
        // dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])
    }

    // Get shortest distance between two nodes
    long getDist(int u, int v) {
        return dist[u][v];
    }

    // Check for negative cycle
    boolean hasNegativeCycle() {
        for (int i = 1; i <= n; i++) {
            if (dist[i][i] < 0) return true;
        }
        return false;
    }

    // Print distance matrix
    void printDistances() {
        System.out.println("Distance Matrix:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // TODO: Implement your test case here
        int n = sc.nextInt();  // number of nodes
        int m = sc.nextInt();  // number of edges

        FloydWarshall graph = new FloydWarshall(n);

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            long w = sc.nextLong();
            graph.addEdge(u, v, w);
        }

        graph.floydWarshall();
        graph.printDistances();

        sc.close();
    }
}
