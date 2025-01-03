class Solution {
    public int waysToSplitArray(int[] nums) {
        long r = 0;
        long l = 0;
        long res = 0;
        for(int num:nums){
            r += num;
        }
        for(int i = 0; i < nums.length-1; i++){
            l += nums[i];
            r -= nums[i];
            if(l >= r){
                res += 1;
            }
        }
        return (int)res;
    }
}