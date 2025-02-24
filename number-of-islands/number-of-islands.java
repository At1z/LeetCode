class Solution {
    public int numIslands(char[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        int res = 0;
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == '1' && visited[row][col] != 1){
                    if(dfs(row,col,grid,visited)){
                        res += 1;
                    }
                }
            }
        }
        return res;
    }
    
    public boolean dfs(int row, int col, char[][] grid, int[][] visited){
        if(row < 0 || row == grid.length || col < 0 || col == grid[0].length || grid[row][col] == '0' ||  visited[row][col] == 1){
            return false;
        }
        visited[row][col] = 1;
        dfs(row + 1, col, grid, visited); // up
        dfs(row - 1, col, grid, visited); // down
        dfs(row, col + 1, grid, visited); // right
        dfs(row, col - 1, grid, visited); // left
        return true;
    }
}