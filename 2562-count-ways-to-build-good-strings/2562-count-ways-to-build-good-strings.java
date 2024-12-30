class Solution {
    int[] memo;
    int MOD = 1_000_000_007;
    
    private int calculate(int length, int a, int b) {
        if (memo[length] != -1)
            return memo[length];
        int result = 0;
        if (length >= b) {
            result += calculate(length - b, a, b);
        }
        if (length >= a) {
            result += calculate(length - a, a, b);
        }
        memo[length] = result % MOD;
        return memo[length];
    }
    
    public int countGoodStrings(int minLength, int maxLength, int a, int b) {
        memo = new int[maxLength + 1];
        Arrays.fill(memo, -1);
        memo[0] = 1;
        
        int total = 0;
        for (int length = minLength; length <= maxLength; ++length) {
            total += calculate(length, a, b);
            total %= MOD;
        }
        return total;
    }
}
