class Solution {
    public int countGoodNumbers(long n) {
        int mod = 1_000_000_007;
        
        long even = (n + 1) / 2; 
        long odd = n / 2;        

        long power5 = modPow(5, even, mod);
        long power4 = modPow(4, odd, mod);

        return (int)((power5 * power4) % mod);
    }

    private long modPow(long base, long exp, int mod) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1)
                result = (result * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }
}
