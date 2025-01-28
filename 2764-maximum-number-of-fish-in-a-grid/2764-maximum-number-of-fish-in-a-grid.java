class Solution {
    public int findMaxFish(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] != 0){
                    visited[i][j] = 1;
                }
            }
        }
        int res = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] > 0 && visited[i][j] > 0){
                    int tempRes = dfs(grid,visited,i, j);
                    System.out.println(tempRes);
                    res = Math.max(res,tempRes);
                }
            }
        }
        return res;
    }
    public int dfs(int[][] grid, int[][] visited, int row,int col){
        int curVal = 0;
        if(visited[row][col] > 0){
            curVal = grid[row][col];
            visited[row][col] = 0;
        }else{
            return 0;
        }
        int up = 0;
        int down = 0;
        int left = 0;
        int right = 0;
        if(row - 1 >= 0  && visited[row-1][col] > 0){
            up = dfs(grid, visited, row-1, col);
        } // up
        if(row + 1 < grid.length  && visited[row+1][col] > 0){
            down = dfs(grid, visited, row+1, col);
        } // down
        if(col - 1 >= 0  && visited[row][col-1] > 0){
            left = dfs(grid, visited, row, col-1);
        } // left
        if(col + 1 < grid[0].length  && visited[row][col+1] > 0){
            right = dfs(grid, visited, row, col+1);
        } // right
        return curVal + up + down + right + left;
    }
}