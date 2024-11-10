class Solution {
    int res = Integer.MAX_VALUE;
    int[] bits = new int[32];
    public int minimumSubarrayLength(int[] nums, int k) {
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            bitsUpdate(bits, nums[r], 1);
            int curOr = bitsToInt(bits);

            while (l <= r && curOr >= k) {
                res = Math.min(res, r - l + 1);
                bitsUpdate(bits, nums[l], -1);
                curOr = bitsToInt(bits);
                l++;
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
        public void bitsUpdate(int[] bits, int n, int diff) {
            for (int i = 0; i < 32; i++) {
                if ((n & (1 << i)) != 0) {
                    bits[i] += diff;
                }
            }
        }
        public int bitsToInt(int[] bits) {
            int result = 0;
            for (int i = 0; i < 32; i++) {
                if (bits[i] > 0) {
                    result |= (1 << i);
                }
            }
            return result;
        }
}