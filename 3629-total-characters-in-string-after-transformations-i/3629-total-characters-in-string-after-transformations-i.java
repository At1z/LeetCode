class Solution {
    public int lengthAfterTransformations(String s, int t) {
        final int MOD = 1_000_000_007;
        long[] count = new long[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (int i = 0; i < t; i++) {
            long[] next = new long[26];
            for (int j = 0; j < 26; j++) {
                if (j == 25) { // 'z'
                    next[0] = (next[0] + count[25]) % MOD;
                    next[1] = (next[1] + count[25]) % MOD;
                } else {
                    next[j + 1] = (next[j + 1] + count[j]) % MOD;
                }
            }
            count = next;
        }

        long total = 0;
        for (long c : count) {
            total = (total + c) % MOD;
        }

        return (int) total;
    }
}
