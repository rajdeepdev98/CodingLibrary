package Algorithms;

public class ModExp {


    public static final int MODNO = (int)(1e9) + 7;


    public int modExp(int base, int exp) {


        long ans = 1;
        long pow = base % MODNO;

        while (exp > 0) {

            if ((exp & 1) != 0) {
                ans = (ans * pow) % MODNO;
            }

            pow = (pow * pow) % MODNO;
            exp >>= 1;
        }

        return (int) ans;
    }
    public int modExpRecursive(int base, int exp) {
        if (exp == 0) {
            return 1;   // base case
        }

        long half = modExpRecursive(base, exp / 2);
        long result = (half * half) % MODNO;

        if (exp % 2 == 1) {
            result = (result * base) % MODNO;
        }

        return (int) result;
    }
}
