class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length; // row
        int n = mat[0].length; // col
        Map<Integer, int[]> position = new HashMap<>();
        int[] rows = new int[m];
        int[] cols = new int[n];
        int res = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                position.put(mat[i][j],new int[]{i,j});
            }
        }
        for(int i = 0; i < arr.length; i++){
            int[] positions = position.get(arr[i]);
            rows[positions[0]] += 1;
            cols[positions[1]] += 1;
            if(rows[positions[0]] == n){
                break;
            }
            if(cols[positions[1]] == m){
                break;
            }
            res += 1;

        }
        return res;
    }
}