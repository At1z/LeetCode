class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        HashSet<String> dictSet = new HashSet<>(Arrays.asList(dictionary));
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n);
        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = dp[i + 1] + 1;
            for (int j = i + 1; j <= n; j++) {
                String sub = s.substring(i, j);
                if (dictSet.contains(sub)) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }

        return dp[0];
    }
}
