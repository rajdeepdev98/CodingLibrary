package Strings;

import java.util.*;

/**
 * Suffix Array implementation with LCP (Longest Common Prefix) array.
 *
 * A suffix array is a sorted array of all suffixes of a string.
 * Time Complexity: O(n log n) for construction
 * Space Complexity: O(n)
 *
 * The LCP array stores the longest common prefix between consecutive suffixes in the SA.
 */
public class SuffixArray {

    private String s;          // Input string with appended sentinel '$'
    private int n;             // Length of string (including sentinel)
    public int[] SA;           // Suffix Array: SA[i] = starting index of i-th smallest suffix
    public int[] LCP;          // LCP[i] = longest common prefix length between suffix at SA[i] and SA[i-1]

    /**
     * Constructs suffix array and LCP array for the given string.
     *
     * @param str The input string
     * @param useCountingSort If true, uses counting sort (faster for small alphabets, O(n log n))
     *                        If false, uses comparison sort (more general, O(n log^2 n))
     */
    public SuffixArray(String str, boolean useCountingSort) {
        this.s = str + "$";    // Append sentinel to ensure all suffixes are unique
        this.n = s.length();
        buildSA(useCountingSort);
        buildLCP();
    }

    // ---------------- MAIN BUILD ----------------
    /**
     * Builds suffix array using prefix doubling algorithm.
     *
     * Algorithm: Start by sorting suffixes by their first character, then by first 2 chars,
     * then 4, 8, 16, ... (doubling k each iteration) until all suffixes are uniquely ranked.
     *
     * At iteration with length k, we sort suffixes by pairs: (rank[i], rank[i+k])
     * This leverages the fact that rank[i..i+k-1] was already computed in previous iteration.
     */
    private void buildSA(boolean useCountingSort) {
        SA = new int[n];
        int[] rank = new int[n];      // Current rank of suffix starting at position i
        int[] tempRank = new int[n];  // Temporary rank array for next iteration

        // Initialize: rank by first character, SA with positions
        for (int i = 0; i < n; i++) {
            SA[i] = i;
            rank[i] = s.charAt(i);
        }

        // Prefix doubling: compare suffixes by first k characters, then 2k, 4k, ...
        for (int k = 1; k < n; k <<= 1) {

            // Sort SA by pairs (rank[i], rank[i+k])
            // For counting sort: sort by second key first (stable), then by first key
            if (useCountingSort) {
                countingSort(k, rank);    // Sort by rank[i+k] (second key)
                countingSort(0, rank);    // Sort by rank[i] (first key), maintaining stability
            } else {
                comparisonSort(rank, k);  // Direct comparison sort
            }

            // Assign new ranks based on sorted order
            tempRank[SA[0]] = 0;
            int r = 0;

            for (int i = 1; i < n; i++) {
                int a = SA[i], b = SA[i - 1];

                // Get second part of the pair (rank at position +k)
                int ra = (a + k < n) ? rank[a + k] : -1;
                int rb = (b + k < n) ? rank[b + k] : -1;

                // If both parts match, assign same rank; otherwise increment
                boolean same = (rank[a] == rank[b]) && (ra == rb);

                tempRank[a] = same ? r : ++r;
            }

            System.arraycopy(tempRank, 0, rank, 0, n);

            // Early termination: if all suffixes have unique ranks, we're done
            if (rank[SA[n - 1]] == n - 1) break;
        }
    }
    // ------- LCP (Kasai's Algorithm) --------
    /**
     * Builds LCP array using Kasai's algorithm in O(n) time.
     *
     * Key insight: If LCP between suffix[i] and its predecessor in SA is k,
     * then LCP between suffix[i+1] and its predecessor is at least k-1.
     * This allows us to avoid recalculating from scratch.
     *
     * LCP[i] stores the longest common prefix length between the suffix starting
     * at position i and the suffix that comes just before it in the sorted suffix array.
     */
    private void buildLCP(){

        int [] rank = new int[n];  // rank[i] = position of suffix[i] in sorted SA
        this.LCP = new int[n];

        // Step 1: Build inverse suffix array (rank array)
        // rank[SA[i]] = i means: suffix starting at SA[i] is at position i in sorted order
        for(int  i = 0;i< n; i++){
            rank[SA[i]] = i;
        }

        int k = 0;  // Length of current LCP being computed

        // Step 2: Compute LCP array by iterating through string positions (not SA order)
        // This ensures we leverage the k-1 property for efficiency
        for(int  i = 0;i< n;i++){

            // Smallest suffix has no predecessor, so LCP is undefined (set to 0)
            if(rank[i] == 0){
                k = 0;
                continue;
            }

            // j = starting position of the suffix that comes just before suffix[i] in SA
            int j = SA[rank[i] - 1];

            // Extend match as far as possible
            while(i+k < n && j+k<n && s.charAt(i+k) == s.charAt(j+k)){
                k++;
            }

            LCP[i] = k;  // Store LCP value for suffix starting at position i

            // For next iteration: LCP will be at least k-1 (removing first character)
            if(k>0) k--;
        }
    }

    // ---------------- COUNTING SORT ----------------
    /**
     * Performs stable counting sort on suffix array based on ranks at offset k.
     *
     * Sorts SA by the rank values at position (SA[i] + k).
     * Stable sort is crucial for the two-pass radix sort in buildSA.
     *
     * @param k The offset from each suffix's starting position to consider
     * @param rank The current rank array
     */
    private void countingSort(int k, int[] rank) {
        int maxVal = Math.max(300, n);  // Max rank value (300 covers ASCII characters)
        int[] count = new int[maxVal];

        // Step 1: Count frequency of each rank value at offset k
        for (int i = 0; i < n; i++) {
            int key = (i + k < n) ? rank[i + k] : 0;  // Use 0 for out-of-bounds
            count[key]++;
        }

        // Step 2: Convert to cumulative sum (prefix sum)
        // After this: count[x] = starting index where rank x should be placed in sorted array
        int sum = 0;
        for (int i = 0; i < maxVal; i++) {
            int temp = count[i];
            count[i] = sum;
            sum += temp;
        }

        int[] tempSA = new int[n];

        // Step 3: Place elements in sorted order (stable placement)
        // Process SA in order to maintain stability
        for (int i = 0; i < n; i++) {
            int key = (SA[i] + k < n) ? rank[SA[i] + k] : 0;
            tempSA[count[key]++] = SA[i];  // Place and increment position
        }

        System.arraycopy(tempSA, 0, SA, 0, n);
    }

    // ---------------- COMPARISON SORT ----------------
    /**
     * Sorts suffix array using comparison-based sort (Arrays.sort).
     *
     * Uses Java's built-in sort with a custom comparator.
     * Compares suffixes by their (rank[i], rank[i+k]) pairs.
     * Time complexity: O(n log n) per iteration due to Arrays.sort.
     *
     * @param rank The current rank array
     * @param k The offset for second comparison key
     */
    private void comparisonSort(int[] rank, int k) {
        Integer[] temp = new Integer[n];

        // Convert to Integer array for custom comparator
        for (int i = 0; i < n; i++) {
            temp[i] = SA[i];
        }

        // Sort by (rank[a], rank[a+k]) pairs lexicographically
        Arrays.sort(temp, (a, b) -> {
            // First, compare by rank at position a vs b
            if (rank[a] != rank[b])
                return Integer.compare(rank[a], rank[b]);

            // If equal, compare by rank at offset +k
            int ra = (a + k < n) ? rank[a + k] : -1;  // -1 for out-of-bounds
            int rb = (b + k < n) ? rank[b + k] : -1;

            return Integer.compare(ra, rb);
        });

        // Copy back to SA
        for (int i = 0; i < n; i++) {
            SA[i] = temp[i];
        }
    }
}