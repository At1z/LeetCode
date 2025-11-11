class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1]; 
        for(String bits : strs){
            int[] counter = countNumbers(bits);
            int zeros = counter[0];
            int ones = counter[1];
            for(int i = m; i >= zeros; i--){
                for(int j = n; j >= ones; j--){
                    dp[i][j] = Math.max(dp[i][j], dp[i-zeros][j-ones] + 1); 
                }
            }
        }

        return dp[m][n];
    }

    private int[] countNumbers(String bits){
        int zeros = 0;
        int ones = 0;
        for(char bit : bits.toCharArray()){
            if(bit == '1'){
                ones += 1;
            }else{
                zeros += 1;
            }
        }
        return new int[]{zeros,ones};
    }
}