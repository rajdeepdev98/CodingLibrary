package RangeQueries;

public class SegmentTreeGenericExample {

    public static void main(String[] args) {

        Integer[] arr = {1, 3, 5, 7, 9, 11};

        // Example 1: Max Query Segment Tree
        System.out.println("=== Max Query Example ===");
        SegmentTreeGeneric<Integer> maxTree = new SegmentTreeGeneric<>(arr, Math::max, Integer.MIN_VALUE);

        System.out.println("Max in range [1, 4]: " + maxTree.query(1, 4)); // 9
        maxTree.update(2, 20);
        System.out.println("After update arr[2] = 20");
        System.out.println("Max in range [1, 4]: " + maxTree.query(1, 4)); // 20

        // Example 2: Sum Query Segment Tree
        System.out.println("\n=== Sum Query Example ===");
        SegmentTreeGeneric<Integer> sumTree = new SegmentTreeGeneric<>(arr, Integer::sum, 0);

        System.out.println("Sum of range [0, 3]: " + sumTree.query(0, 3)); // 1+3+5+7 = 16
        sumTree.update(1, 10);
        System.out.println("After update arr[1] = 10");
        System.out.println("Sum of range [0, 3]: " + sumTree.query(0, 3)); // 1+10+5+7 = 23

        // Example 3: Min Query Segment Tree
        System.out.println("\n=== Min Query Example ===");
        SegmentTreeGeneric<Integer> minTree = new SegmentTreeGeneric<>(arr, Math::min, Integer.MAX_VALUE);

        System.out.println("Min in range [2, 5]: " + minTree.query(2, 5)); // 5
        minTree.update(3, 2);
        System.out.println("After update arr[3] = 2");
        System.out.println("Min in range [2, 5]: " + minTree.query(2, 5)); // 2

        // Example 4: Custom merge function (GCD)
        System.out.println("\n=== GCD Query Example ===");
        Integer[] gcdArr = {12, 18, 24, 30, 36};
        SegmentTreeGeneric<Integer> gcdTree = new SegmentTreeGeneric<>(
            gcdArr,
            (a, b) -> gcd(a, b),  // Custom lambda for GCD
            0
        );

        System.out.println("GCD of range [0, 2]: " + gcdTree.query(0, 2)); // gcd(12,18,24) = 6
        System.out.println("GCD of range [1, 4]: " + gcdTree.query(1, 4)); // gcd(18,24,30,36) = 6

        // Example 5: Building from scratch (empty tree)
        System.out.println("\n=== Empty Tree Example ===");
        SegmentTreeGeneric<Integer> emptyTree = new SegmentTreeGeneric<>(5, Integer::sum, 0);
        emptyTree.update(0, 10);
        emptyTree.update(2, 20);
        emptyTree.update(4, 30);
        System.out.println("Sum of range [0, 4]: " + emptyTree.query(0, 4)); // 10+0+20+0+30 = 60
    }

    // Helper method for GCD
    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
