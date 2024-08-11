//https://www.geeksforgeeks.org/find-the-number-of-islands-using-dfs/

class Solution {
    public int minDays(int[][] grid) {
        if (countIslands(grid) != 1) {
            return 0; 
        }

        int ROW = grid.length;
        int COL = grid[0].length;

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0; 
                    if (countIslands(grid) != 1) {
                        return 1; 
                    }
                    grid[i][j] = 1; 
                }
            }
        }
        return 2;
    }

    public static void DFS(int[][] M, int i, int j, int ROW, int COL) {

        if (i < 0 || j < 0 || i >= ROW || j >= COL || M[i][j] != 1) {
            return;
        }
        M[i][j] = 0;

        DFS(M, i + 1, j, ROW, COL); // right side traversal
        DFS(M, i - 1, j, ROW, COL); // left side traversal
        DFS(M, i, j + 1, ROW, COL); // upward side traversal
        DFS(M, i, j - 1, ROW, COL); // downward side traversal
    }

    public static int countIslands(int[][] M) {
        int ROW = M.length;
        int COL = M[0].length;
        int count = 0;

        int[][] copy = new int[ROW][COL];
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                copy[i][j] = M[i][j];
            }
        }
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (copy[i][j] == 1) {
                    count++;
                    DFS(copy, i, j, ROW, COL); 
                }
            }
        }
        return count;
    }
}
