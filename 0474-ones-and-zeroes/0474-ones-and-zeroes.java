class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1]; 

        for (String s : strs) {
            int zeros = 0;
            int ones = 0;
            //System.out.println("-------------------");
            //System.out.println(s);
            //System.out.println();

            for (char c : s.toCharArray()) {
                if (c == '0') zeros++;
                else ones++;
            }
            //System.out.println("0: " + zeros + ", 1: " + ones);
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    //System.out.println("dp[" + i + "][" + j + "]: " + dp[i][j]);
                    //System.out.println("dp[" + (i - zeros) + "][" + (j - ones + 1) + "]: " + (dp[i - zeros][j - ones] + 1)); 
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                    //System.out.println("dp[" + i + "][" + j + "]: " + dp[i][j]);
                    //System.out.println();

                }
            }

        }

        return dp[m][n];
    }
}