class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int x = 0, y = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // N, E, S, W
        int d = 0;
        int res = 0;
        
        Set<String> obstacleSet = new HashSet<>();
        for (int[] o : obstacles) {
            obstacleSet.add(o[0] + "," + o[1]);
        }
        
        for (int c : commands) {
            if (c == -1) {
                d = (d + 1) % 4;
            } else if (c == -2) {
                d = (d - 1 + 4) % 4;
            } else {
                int dx = directions[d][0];
                int dy = directions[d][1];
                for (int i = 0; i < c; i++) {
                    int nextX = x + dx;
                    int nextY = y + dy;
                    if (obstacleSet.contains(nextX + "," + nextY)) {
                        break;
                    }
                    x = nextX;
                    y = nextY;
                    res = Math.max(res, x * x + y * y);
                }
            }
        }
        
        return res;
    }
}