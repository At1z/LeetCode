class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        
        Deque<int[]> deque = new LinkedList<>();
        deque.offer(new int[]{0, 0});
        
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        while (!deque.isEmpty()) {
            int[] curr = deque.poll();
            int row = curr[0];
            int col = curr[1];
            
            for (int i = 0; i < 4; i++) {
                int newRow = row + dirs[i][0];
                int newCol = col + dirs[i][1];
                
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
                    int cost = grid[row][col] == i + 1 ? 0 : 1;
                    if (dist[newRow][newCol] > dist[row][col] + cost) {
                        dist[newRow][newCol] = dist[row][col] + cost;
                        if (cost == 0) {
                            deque.addFirst(new int[]{newRow, newCol});
                        } else {
                            deque.addLast(new int[]{newRow, newCol});
                        }
                    }
                }
            }
        }
        
        return dist[m-1][n-1];
    }
}