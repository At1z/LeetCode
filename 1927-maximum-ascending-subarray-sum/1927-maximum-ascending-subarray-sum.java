class Solution {
    public int maxAscendingSum(int[] nums) {
        int res = nums[0];
        int cRes = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i-1]){
                cRes += nums[i];
            }else{
                cRes = nums[i];
            }
            res = Math.max(res,cRes);
        }
        return res;
    }
}