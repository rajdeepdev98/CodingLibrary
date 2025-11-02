import java.util.*;

/**
 * Algorithm: Breadth-First Search (BFS)
 * Time Complexity: O(V + E)
 * Space Complexity: O(V)
 * Use case: Level-order traversal, shortest path in unweighted graphs
 */
public class BFS {

    List<Integer>[] adj;
    boolean[] visited;
    int[] dist;
    int[] parent;
    int n;

    @SuppressWarnings("unchecked")
    public BFS(int n) {
        this.n = n;
        adj = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        dist = new int[n + 1];
        parent = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
            parent[i] = -1;
            dist[i] = -1;
        }
    }

    void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);  // For undirected graph
    }

    // Run BFS from source node
    void bfs(int source) {
        // TODO: Implement BFS algorithm
        // 1. Use queue for level-order traversal
        // 2. Mark source as visited, dist[source] = 0
        // 3. Process all neighbors level by level
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(source);
        this.dist[source] = 0;
        this.visited[source] = true; // node should be marked visited before adding to the queue

        while(!queue.isEmpty()){

            int node = queue.poll();
            this.visited[node] = true;

            for (int el : adj[node]){

                 if( !this.visited[el]){

                     queue.add(el);
                     this.visited[el] = true;
                     this.dist[el] = this.dist[node]+1;
                     this.parent[el]  = node;

                 }

            }
        }
    }

    // Get shortest distance (number of edges)
    int getDist(int node) {
        return visited[node] ? dist[node] : -1;
    }

    // Get shortest path from source to node
    List<Integer> getPath(int node) {
        if (!visited[node]) return new ArrayList<>();

        List<Integer> path = new ArrayList<>();
        int current = node;
        while (current != -1) {
            path.add(current);
            current = parent[current];
        }
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // TODO: Implement your test case here
        int n = sc.nextInt();  // number of nodes
        int m = sc.nextInt();  // number of edges
        int source = sc.nextInt();

        BFS graph = new BFS(n);

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.addEdge(u, v);
        }

        graph.bfs(source);

        for (int i = 1; i <= n; i++) {
            System.out.println("Distance to " + i + ": " + graph.getDist(i));
        }

        sc.close();
    }
}
