class Solution {
    public long coloredCells(int n) {
        // n = 1 res = 1
        // n = 2 res = 1 + 4
        // n = 3 res = 1 + 4 + 8
        // n = 4 res = 1 + 4 + 8 + 12
        // each step take + (previous + 4) to res
        n -= 1;
        long res = 1;
        long add = 4;
        while(n > 0){
            res += add;
            add += 4;
            n -= 1;
        }

        return res;
    }
        /*
        int[][] grid = new int[n + n - 1][n + n - 1];
        long res = 0;
        dfs(grid, n - 1, n - 1, 0, n);
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    res += 1;
                }
            }
        }
        return res;
    }

    public void dfs(int[][] grid, int row, int col, int counter, int n){
        if(counter == n || row < 0 || row == grid.length || col < 0 || col == grid[0].length){
            return;
        }
        grid[row][col] = 1;
        dfs(grid, row - 1, col,  counter + 1, n); // up
        dfs(grid, row + 1, col,  counter + 1, n); // down
        dfs(grid, row, col - 1,  counter + 1, n); // left
        dfs(grid, row, col + 1,  counter + 1, n); // right
        
    }
    */
}