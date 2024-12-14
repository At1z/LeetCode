class Solution {
    public long continuousSubarrays(int[] nums) {
        long res = 0;
        int l = 0;
        int r = 0;
        int minVal = nums[0];
        int maxVal = nums[0]; 

        while (r < nums.length) {
            minVal = Math.min(minVal, nums[r]);
            maxVal = Math.max(maxVal, nums[r]);
            while (maxVal - minVal > 2) {
                l++;
                minVal = nums[l];
                maxVal = nums[l];
                for (int i = l; i <= r; i++) {
                    minVal = Math.min(minVal, nums[i]);
                    maxVal = Math.max(maxVal, nums[i]);
                }
            }
            res += r - l + 1;
            r++;
        }
        return res;
    }
}
