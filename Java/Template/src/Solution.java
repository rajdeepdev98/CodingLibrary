import java.io.*;
import java.util.*;

public class Solution {
    static FastScanner sc = new FastScanner();
    static PrintWriter out = new PrintWriter(System.out);

    public static void solve() {
        // Write your solution here

    }

    public static void main(String[] args) {
        int t = 1;
        // t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
        out.close();
    }

    // Helper methods for printing
    static void print(Object x) {
        out.print(x);
    }

    static void println(Object x) {
        out.println(x);
    }

    static void println() {
        out.println();
    }

    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            out.print(arr[i] + (i == arr.length - 1 ? "" : " "));
        }
        out.println();
    }

    static void printArray(long[] arr) {
        for (int i = 0; i < arr.length; i++) {
            out.print(arr[i] + (i == arr.length - 1 ? "" : " "));
        }
        out.println();
    }

    // Helper methods for max/min
    static int max(int... values) {
        int max = Integer.MIN_VALUE;
        for (int v : values) max = Math.max(max, v);
        return max;
    }

    static long max(long... values) {
        long max = Long.MIN_VALUE;
        for (long v : values) max = Math.max(max, v);
        return max;
    }

    static int min(int... values) {
        int min = Integer.MAX_VALUE;
        for (int v : values) min = Math.min(min, v);
        return min;
    }

    static long min(long... values) {
        long min = Long.MAX_VALUE;
        for (long v : values) min = Math.min(min, v);
        return min;
    }

    static int maxArray(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int v : arr) max = Math.max(max, v);
        return max;
    }

    static long maxArray(long[] arr) {
        long max = Long.MIN_VALUE;
        for (long v : arr) max = Math.max(max, v);
        return max;
    }

    static int minArray(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int v : arr) min = Math.min(min, v);
        return min;
    }

    static long minArray(long[] arr) {
        long min = Long.MAX_VALUE;
        for (long v : arr) min = Math.min(min, v);
        return min;
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
