package Graph.MST;

import java.util.*;

/**
 * Algorithm: Disjoint Set Union (Union-Find)
 * Time Complexity: O(α(n)) per operation (nearly constant)
 * Space Complexity: O(n)
 * Use case: Track disjoint sets, cycle detection, Kruskal's MST
 */
public class DSU {

    int[] parent;
    int[] rank;  // or size
    int n;

    // Constructor
    public DSU(int n) {
        this.n = n;
        parent = new int[n + 1];
        rank = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    // Find with path compression
    int find(int x) {
        // TODO: Implement find with path compression
        // if (parent[x] != x) parent[x] = find(parent[x]);
        // return parent[x];
        return x;
    }

    // Union by rank
    boolean union(int x, int y) {
        // TODO: Implement union by rank
        // Return true if union successful, false if already in same set
        return true;
    }

    // Check if two elements are in same set
    boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

    // Get number of disjoint sets
    int countSets() {
        Set<Integer> uniqueParents = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            uniqueParents.add(find(i));
        }
        return uniqueParents.size();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // TODO: Implement your test case here
        int n = sc.nextInt();  // number of elements
        int q = sc.nextInt();  // number of queries

        DSU dsu = new DSU(n);

        for (int i = 0; i < q; i++) {
            String type = sc.next();
            int x = sc.nextInt();
            int y = sc.nextInt();

            if (type.equals("union")) {
                dsu.union(x, y);
            } else if (type.equals("find")) {
                System.out.println(dsu.isConnected(x, y) ? "YES" : "NO");
            }
        }

        sc.close();
    }
}
