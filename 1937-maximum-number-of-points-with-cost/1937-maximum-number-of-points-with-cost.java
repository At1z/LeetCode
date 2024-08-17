class Solution {
    public long maxPoints(int[][] points) {
        int rows = points.length;
        int cols = points[0].length;

        long[] prev = new long[cols];

        for (int j = 0; j < cols; j++) {
            prev[j] = points[0][j];
        }

        for (int i = 1; i < rows; i++) {
            long[] cur = new long[cols];

            long[] leftMax = new long[cols];
            leftMax[0] = prev[0];
            for (int j = 1; j < cols; j++) {
                leftMax[j] = Math.max(leftMax[j - 1], prev[j] + j);
            }

            long[] rightMax = new long[cols];
            rightMax[cols - 1] = prev[cols - 1] - (cols - 1);
            for (int j = cols - 2; j >= 0; j--) {
                rightMax[j] = Math.max(rightMax[j + 1], prev[j] - j);
            }

            for (int j = 0; j < cols; j++) {
                cur[j] = points[i][j] + Math.max(leftMax[j] - j, rightMax[j] + j);
            }


            prev = cur;
        }

        long result = 0;
        for (int j = 0; j < cols; j++) {
            result = Math.max(result, prev[j]);
        }

        return result;
    }
}
