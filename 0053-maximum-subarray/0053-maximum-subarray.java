class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int maxSum = nums[0];
        for(int i = 1; i < dp.length; i++){
            dp[i] = nums[i] + Math.max(0, dp[i-1]);
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }
}