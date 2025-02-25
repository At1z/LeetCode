class Solution {
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        int[][] dp = new int[m][n];
        int res = dfs(0,0,grid, dp);
        return res;
    }
    public int dfs(int row, int col, int[][]grid, int[][] dp ){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length){
            return 0;
        }
        if(dp[row][col] != 0){
            return dp[row][col];
        }
        if(row ==  grid.length - 1 && col == grid[0].length - 1){
            return 1;
        }
        int right = dfs(row, col + 1, grid, dp);
        int down = dfs(row + 1, col, grid, dp);
        dp[row][col] = right + down;
        
        return dp[row][col];
    }
}