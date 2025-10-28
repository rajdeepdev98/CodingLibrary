import java.util.*;

/**
 * Algorithm: 2-SAT (2-Satisfiability)
 * Time Complexity: O(V + E)
 * Space Complexity: O(V + E)
 * Use case: Solve boolean satisfiability with clauses of 2 literals
 */
public class TwoSAT {

    List<Integer>[] adj, radj;
    boolean[] visited;
    Stack<Integer> stack;
    int[] comp;
    int numVars;
    int numComps;

    @SuppressWarnings("unchecked")
    public TwoSAT(int numVars) {
        this.numVars = numVars;
        int n = 2 * numVars;  // Each variable has true/false nodes
        adj = new ArrayList[n];
        radj = new ArrayList[n];
        visited = new boolean[n];
        stack = new Stack<>();
        comp = new int[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
            radj[i] = new ArrayList<>();
        }
    }

    // Map variable and its value to node index
    // var 1, true -> 0, var 1, false -> 1
    // var 2, true -> 2, var 2, false -> 3, etc.
    int getNode(int var, boolean val) {
        return 2 * (var - 1) + (val ? 0 : 1);
    }

    // Add clause: (a OR b)
    // Equivalent to: (!a -> b) AND (!b -> a)
    void addClause(int a, boolean valA, int b, boolean valB) {
        int nodeA = getNode(a, valA);
        int nodeB = getNode(b, valB);
        int notA = getNode(a, !valA);
        int notB = getNode(b, !valB);

        // !a -> b
        adj[notA].add(nodeB);
        radj[nodeB].add(notA);

        // !b -> a
        adj[notB].add(nodeA);
        radj[nodeA].add(notB);
    }

    // DFS for Kosaraju's algorithm
    void dfs1(int node) {
        // TODO: Implement first DFS
    }

    void dfs2(int node, int c) {
        // TODO: Implement second DFS
    }

    // Find SCCs
    void findSCCs() {
        // TODO: Implement Kosaraju's algorithm
    }

    // Check if satisfiable
    boolean isSatisfiable() {
        // TODO: Check satisfiability
        // For each variable, check if x and !x are in same SCC
        // If yes, unsatisfiable
        return true;
    }

    // Get solution assignment
    boolean[] getSolution() {
        // TODO: Get variable assignments
        // For each variable, assign true if SCC of true-node > SCC of false-node
        return new boolean[numVars + 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // TODO: Implement your test case here
        int n = sc.nextInt();  // number of variables
        int m = sc.nextInt();  // number of clauses

        TwoSAT sat = new TwoSAT(n);

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            // Positive means true, negative means false
            boolean valA = a > 0;
            boolean valB = b > 0;
            sat.addClause(Math.abs(a), valA, Math.abs(b), valB);
        }

        sat.findSCCs();

        if (sat.isSatisfiable()) {
            System.out.println("SATISFIABLE");
            boolean[] solution = sat.getSolution();
            for (int i = 1; i <= n; i++) {
                System.out.println("x" + i + " = " + solution[i]);
            }
        } else {
            System.out.println("UNSATISFIABLE");
        }

        sc.close();
    }
}
