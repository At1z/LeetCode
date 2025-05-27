class Solution {
    public int differenceOfSums(int n, int m) {
        int maxSum = n*(n+1)/2;
        int diff = 0;
        for(int i = 1; i <= n; i++){
            if(i % m == 0){
                diff += i;
            }
        }
        return maxSum - 2 * diff;
    }
}