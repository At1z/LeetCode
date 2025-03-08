class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int zero = 0;
        int size = 0;
        while (r < nums.length) {
            if (nums[r] == 0) {
                zero += 1;
            }
            while (zero > k) {
                if (nums[l] == 0) {
                    zero -= 1;
                }
                l += 1;
            }
            size = Math.max(size, r - l + 1);
            r += 1;
        }
        
        return size;
    }
}
