class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid2.length;
        int n = grid2[0].length;
        int subIslandsCount = 0;

   
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                if (grid2[i][j] == 1) {
                    
                    if (dfs(grid1, grid2, i, j)) {
                        subIslandsCount++;
                    }
                }
            }
        }

        return subIslandsCount;
    }

   
    private boolean dfs(int[][] grid1, int[][] grid2, int i, int j) {
        int m = grid2.length;
        int n = grid2[0].length;

       
        if (i < 0 || i >= m || j < 0 || j >= n || grid2[i][j] == 0) {
            return true;
        }

        
        boolean isSubIsland = grid1[i][j] == 1;

       
        grid2[i][j] = 0;

     
        boolean up = dfs(grid1, grid2, i - 1, j);
        boolean down = dfs(grid1, grid2, i + 1, j);
        boolean left = dfs(grid1, grid2, i, j - 1);
        boolean right = dfs(grid1, grid2, i, j + 1);

        
        return isSubIsland && up && down && left && right;
    }
}
