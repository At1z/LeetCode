class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int l = 0;
        int r = 0;
        int curSum = 0;
        int res = 0;
        while(r < arr.length){
            while(r < arr.length && r - l < k){
                curSum += arr[r];
                r += 1;
            }
            if(curSum/k >= threshold){
                res += 1;
            }
            curSum -= arr[l];
            l += 1;
        }

        return res;
    }
}