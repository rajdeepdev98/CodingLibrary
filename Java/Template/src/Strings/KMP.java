package Strings;

/**
 * KMP (Knuth-Morris-Pratt) String Matching Algorithm implementation.
 *
 * The KMP algorithm efficiently finds pattern occurrences in a text in O(n + m) time,
 * where n is the text length and m is the pattern length.
 *
 * Core component: Prefix Function (Failure Function)
 * - Computes the longest proper prefix which is also a suffix for each position
 * - Used to avoid redundant comparisons during pattern matching
 */
public class KMP {

    /**
     * Computes the prefix function (failure function) for the given string.
     *
     * The prefix function π[i] is defined as the length of the longest proper prefix
     * of the substring s[0...i] which is also a suffix of this substring.
     *
     * Example: For string "ababaca"
     * - π = [0, 0, 1, 2, 3, 0, 1]
     * - At i=4: s[0..4] = "ababa", longest prefix = "aba" (length 3)
     *
     * Time Complexity: O(n) where n is the length of string
     * Space Complexity: O(n) for the prefix array
     *
     * @param s The input string
     * @return Prefix array where prefixArray[i] = length of longest proper prefix
     *         of s[0..i] that is also a suffix
     */
    public int [] prefixFunction(String s){

        int n = s.length();
        char [] c = s.toCharArray();

        int [] prefixArray = new int [n];  // prefixArray[i] stores π[i]

        // prefixArray[0] is always 0 (no proper prefix for single character)
        // Start from i=1
        for(int i = 1;i < n; i++){

            // j = length of the previous longest prefix-suffix
            int j = prefixArray[i-1];

            // If current character doesn't match, fall back to shorter prefix
            // This is the key optimization: we use previously computed values
            while(j > 0 && c[i] != c[j]){
                // Jump to the next shorter candidate prefix length
                j = prefixArray[j-1];
            }

            // If characters match, extend the prefix length
            if(c[i] == c[j]){
                j++;
            }

            // Store the longest prefix-suffix length for position i
            prefixArray[i] = j;
        }

        return prefixArray;
    }

    public static void main(String[] args) {

    }
}
