class Solution {
    public int maxMoves(int[][] grid) {
        int max = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] memo = new int[rows][cols];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < rows; i++) {  
            max = Math.max(max, moves(0, i, grid, memo));
        }
        /*
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                System.out.print(memo[i][j] + "  " );
            }
            System.out.println();
        }
        */
        return max;
    }
    
    private int moves(int col, int row, int[][] grid, int[][] memo) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (col == cols - 1) {
            return 0;
        }

        if (memo[row][col] != -1) {
            return memo[row][col];
        }

        int right = 0;
        int rightDown = 0;
        int rightUp = 0;

        // Move right
        if (col + 1 < cols && grid[row][col] < grid[row][col + 1]) {
            right = 1 + moves(col + 1, row, grid, memo);
        }
        // Move right-down
        if (col + 1 < cols && row + 1 < rows && grid[row][col] < grid[row + 1][col + 1]) {
            rightDown = 1 + moves(col + 1, row + 1, grid, memo);
        }
        // Move right-up
        if (col + 1 < cols && row - 1 >= 0 && grid[row][col] < grid[row - 1][col + 1]) {
            rightUp = 1 + moves(col + 1, row - 1, grid, memo);
        }
        memo[row][col] = Math.max(right, Math.max(rightDown, rightUp));
        return memo[row][col];
    }
}
