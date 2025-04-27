class Solution {
    public int countSubarrays(int[] nums) {
        int numsLength = nums.length;
        int res = 0;
        if(numsLength < 3){
            return res;
        }
        int l = 0;
        double mid = nums[1];
        for(int r = 2; r < nums.length; r++){
            if(nums[l] + nums[r] == mid/2){
                res += 1;
            }
            mid = nums[r];
            l += 1;
        }
        return res;
    }
}