class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        
        for (int length = 2; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                dp[i][j] = Integer.MAX_VALUE;
                
                
    
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j]);
                    //System.out.println("Jestem z FOR");
                    //System.out.println("i = "+ i + " " + s.charAt(i) + " j = "+ j + " " + s.charAt(j));
                    //System.out.println(" k+1, j dp[" + (k + 1) + "][" + j + "] = " + dp[(k + 1)][j]);
                    //System.out.println(" i, k   dp[" + i + "][" + k + "] = " + dp[i][k]);
                    //System.out.println(" i, j   dp[" + i + "][" + j + "] = " + dp[i][j]);

                }
                
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1]);
                    //System.out.println("Jestem z IF");
                    //System.out.println("i " + s.charAt(i) + " j " + s.charAt(j));
                    //System.out.println("dp[" + i + "][" + j + "] = " + dp[i][j]);
                }
            }
        }
        
        return dp[0][n - 1];
    }
}