class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;

        int maxDiff = 0;  // max (nums[i] - nums[j])
        long maxRes = 0;  // max (nums[i] - nums[j]) * nums[k]
        int maxCurVal = nums[0];

        for (int j = 1; j < n; j++) {
            maxRes = Math.max(maxRes, (long) maxDiff * nums[j]);
            maxDiff = Math.max(maxDiff, maxCurVal - nums[j]);
            maxCurVal = Math.max(maxCurVal, nums[j]);
        }
        
        return maxRes;
    }
}
