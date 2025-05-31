class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] visited = new boolean[n * n + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0});
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int square = current[0];
            int moves = current[1];

            for (int i = 1; i <= 6 && square + i <= n * n; i++) {
                int nextSquare = square + i;
                int[] pos = getCoordinates(nextSquare, n);
                int r = pos[0], c = pos[1];
                if (board[r][c] != -1) {
                    nextSquare = board[r][c];
                }

                if (!visited[nextSquare]) {
                    if (nextSquare == n * n) return moves + 1;
                    visited[nextSquare] = true;
                    queue.offer(new int[]{nextSquare, moves + 1});
                }
            }
        }

        return -1;
    }

    private int[] getCoordinates(int square, int n) {
        int quot = (square - 1) / n;
        int rem = (square - 1) % n;
        int row = n - 1 - quot;
        int col = (quot % 2 == 0) ? rem : n - 1 - rem;
        return new int[]{row, col};
    }
}
