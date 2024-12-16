class Solution {
    public double findMaxAverage(int[] nums, int k) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i - 1];
        }
        int max = nums[k - 1]; 
        for (int i = k; i < nums.length; i++) {
            int curMax = nums[i] - nums[i - k];
            max = Math.max(max, curMax);
        }
        return (double) max / k;
    }
}
