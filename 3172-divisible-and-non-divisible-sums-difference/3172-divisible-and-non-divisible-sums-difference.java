class Solution {
    public int differenceOfSums(int n, int m) {
        int maxSum = n*(n+1)/2;
        int diff = (n/m) *((n/m)+1)*m;
        return maxSum - diff;
    }
}