class Solution {
    public int minCapability(int[] nums, int k) {
        int l = 1;
        int r = 0;
        int res = 0;
        
        for (int num : nums) {
            r = Math.max(r, num);
        }

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int count = 0;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    count++;
                    i++; 
                }
            }

            if (count >= k) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return res;
    }
}
