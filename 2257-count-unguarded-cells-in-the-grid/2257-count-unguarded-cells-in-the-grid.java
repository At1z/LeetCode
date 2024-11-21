class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int res = m * n; 
        int[][] grid = new int[m][n];

        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 1;
            res--; 
        }
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 2;
            res--; 
        }
        for (int[] guard : guards) {
            dfs(guard[0] - 1, guard[1], grid, "Up");    
            dfs(guard[0] + 1, guard[1], grid, "Down");  
            dfs(guard[0], guard[1] - 1, grid, "Left");  
            dfs(guard[0], guard[1] + 1, grid, "Right");
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 3) {
                    res--;
                }
            }
        }

        return res;
    }

    public void dfs(int row, int col, int[][] grid, String direction) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 1 || grid[row][col] == 2) {
            return; 
        }
        grid[row][col] = 3; 
        if (direction.equals("Up")) {
            dfs(row - 1, col, grid, "Up");
        } else if (direction.equals("Down")) {
            dfs(row + 1, col, grid, "Down");
        } else if (direction.equals("Left")) {
            dfs(row, col - 1, grid, "Left");
        } else if (direction.equals("Right")) {
            dfs(row, col + 1, grid, "Right");
        }
    }
}
