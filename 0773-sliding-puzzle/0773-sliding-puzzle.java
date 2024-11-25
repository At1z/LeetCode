class Solution {
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        StringBuilder start = new StringBuilder();
        for (int[] row : board) {
            for (int cell : row) {
                start.append(cell);
            }
        }
        if (start.toString().equals(target)) return 0;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start.toString());
        visited.add(start.toString());
        int moves = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            moves++;
            
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                int zeroIndex = current.indexOf('0');
                int zeroRow = zeroIndex / 3;
                int zeroCol = zeroIndex % 3;
                for (int[] dir : directions) {
                    int newRow = zeroRow + dir[0];
                    int newCol = zeroCol + dir[1];
                    if (newRow >= 0 && newRow < 2 && newCol >= 0 && newCol < 3) {
                        char[] chars = current.toCharArray();
                        int newIndex = newRow * 3 + newCol;
                        chars[zeroIndex] = chars[newIndex];
                        chars[newIndex] = '0';
                        String newState = new String(chars);
                        if (newState.equals(target)) return moves;
                        if (!visited.contains(newState)) {
                            queue.offer(newState);
                            visited.add(newState);
                        }
                    }
                }
            }
        }
        return -1;
    }
}
