class Solution {
    public int minimumObstacles(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] points = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(points[i], Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{0, 0, 0});
        points[0][0] = 0;
        int[] directions = {-1, 0, 1, 0, -1};
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int r = current[0], c = current[1], obstacles = current[2];
            if (r == rows - 1 && c == cols - 1) {
                return obstacles;
            }
            for (int i = 0; i < 4; i++) {
                int nRow = r + directions[i], nCol = c + directions[i + 1];
                if (nRow >= 0 && nRow < rows && nCol >= 0 && nCol < cols) {
                    int newObstacles = obstacles + (grid[nRow][nCol] == 1 ? 1 : 0);
                    if (newObstacles < points[nRow][nCol]) {
                        points[nRow][nCol] = newObstacles;
                        pq.offer(new int[]{nRow, nCol, newObstacles});
                    }
                }
            }
        }
        
        return -1; 
    }
}
/*
class Solution {
    public int minimumObstacles(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] points = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(points[i], (int) Math.pow(10, 5));
        }
        dfs(0, 0, grid, points, 0);
        return points[rows - 1][cols - 1];
    }

    public void dfs(int row, int col, int[][] grid, int[][] points, int temp) {
        if (grid[row][col] == 1) {
            temp += 1;
        }

        if (temp < points[row][col]) {
            points[row][col] = temp;
        } else {
            return; 
        }

        if (row - 1 >= 0) {
            dfs(row - 1, col, grid, points, temp); // up
        }
        if (row + 1 < grid.length) {
            dfs(row + 1, col, grid, points, temp); // down
        }
        if (col - 1 >= 0) {
            dfs(row, col - 1, grid, points, temp); // left
        }
        if (col + 1 < grid[0].length) {
            dfs(row, col + 1, grid, points, temp); // right
        }
    }
}
*/