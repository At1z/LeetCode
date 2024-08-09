class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int amountOfMagicSquare = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        if (cols < 3 || rows < 3) {
            return 0;
        }

        for (int row = 0; row <= rows - 3; row++) {
            for (int col = 0; col <= cols - 3; col++) {
                if (isMagicSquare(grid, row, col)) {
                    amountOfMagicSquare++;
                }
            }
        }
        return amountOfMagicSquare;
    }

    private boolean isMagicSquare(int[][] grid, int row, int col) {

        boolean[] seen = new boolean[10];
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                int num = grid[i][j];
                if (num < 1 || num > 9 || seen[num]) {
                    return false;
                }
                seen[num] = true;
            }
        }

        int sum = grid[row][col] + grid[row][col + 1] + grid[row][col + 2];

        for (int i = 0; i < 3; i++) {
            int rowSum = 0;
            int colSum = 0;
            for (int j = 0; j < 3; j++) {
                rowSum += grid[row + i][col + j];
                colSum += grid[row + j][col + i];
            }
            if (rowSum != sum || colSum != sum) {
                return false;
            }
        }


        int diag1 = grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2];
        int diag2 = grid[row][col + 2] + grid[row + 1][col + 1] + grid[row + 2][col];

        return diag1 == sum && diag2 == sum;
    }
}
