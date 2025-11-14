class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] diff = new int[n+1][n+1];
        int[][] mat = new int[n][n];

        for(int[] q : queries){
            diff[q[0]][q[1]] += 1;
            diff[q[2] + 1][q[1]] -= 1;
            diff[q[0]][q[3] + 1] -= 1;
            diff[q[2]+1][q[3]+1] += 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x1 = (i == 0) ? 0 : mat[i - 1][j];
                int x2 = (j == 0) ? 0 : mat[i][j - 1];
                int x3 = (i == 0 || j == 0) ? 0 : mat[i - 1][j - 1];
                mat[i][j] = diff[i][j] + x1 + x2 - x3;
            }
        }
        return mat;
    }
}