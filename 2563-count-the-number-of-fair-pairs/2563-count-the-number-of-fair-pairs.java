class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long res = 0;
        
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            int lowerBound = binarySearch(nums, left, right, lower - nums[i], true);
            int upperBound = binarySearch(nums, left, right, upper - nums[i], false);
            if (lowerBound <= upperBound) {
                res += (upperBound - lowerBound + 1);
            }
        }
        return res;
    }
    private int binarySearch(int[] nums, int left, int right, int target, boolean isLower) {
        int result = isLower ? right + 1 : left - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isLower) {
                if (nums[mid] >= target) {
                    result = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] <= target) {
                    result = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return result;
    }
}
