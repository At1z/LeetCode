class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> map = new HashMap<>();
        for (int[] row : matrix) {
            StringBuilder original = new StringBuilder();
            StringBuilder flipped = new StringBuilder();

            for (int cell : row) {
                original.append(cell); 
                flipped.append(cell ^ 1); 
            }
            String originalStr = original.toString();
            String flippedStr = flipped.toString();

            map.put(originalStr, map.getOrDefault(originalStr, 0) + 1);
            map.put(flippedStr, map.getOrDefault(flippedStr, 0) + 1);
        }
        int maxRows = 0;
        for (int count : map.values()) {
            maxRows = Math.max(maxRows, count);
        }
        return maxRows;
    }
}
