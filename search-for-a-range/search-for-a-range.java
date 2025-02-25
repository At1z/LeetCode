class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        res[0] = findBound(nums, target, true);  
        res[1] = findBound(nums, target, false); 
        return res;
    }

    private int findBound(int[] nums, int target, boolean isLeft) {
        int l = 0, r = nums.length - 1;
        int bound = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                bound = mid; 
                if (isLeft) {
                    r = mid - 1; 
                } else {
                    l = mid + 1; 
                }
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return bound;
    }
}
