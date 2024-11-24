class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        long res = 0;
        int fMin = -100000;
        int fMinPlus = 100000;
        int minusValue = 0;
        for(int i = 0; i < n; i++){ 
            for(int j = 0; j < n; j++){
                res += Math.abs(matrix[i][j]);
                if(matrix[i][j] <= 0){
                    minusValue += 1;
                    fMin = Math.max(fMin, matrix[i][j]);
                }else{
                    fMinPlus = Math.min(fMinPlus,matrix[i][j]);
                }
            }
        }
    if(minusValue % 2 != 0){
        fMin = Math.min(fMinPlus,Math.abs(fMin));
        res -= 2*fMin;
    }
    return res;  
    }
}