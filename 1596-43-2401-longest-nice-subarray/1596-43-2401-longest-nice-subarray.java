class Solution {
    public int longestNiceSubarray(int[] nums) {
        int l = 0;
        int r = 0;
        int bitMask = 0;
        int maxLength = 1;
        while(r < nums.length){
            while(r < nums.length && (nums[r] & bitMask) == 0){
                bitMask |= nums[r]; 
                r += 1;
            }
            maxLength = Math.max(maxLength, r - l);
            while(r < nums.length && (nums[r] & bitMask) != 0){
                bitMask &= ~nums[l];
                l += 1;
            }
            
        }
        return maxLength;
    }
}
//16
// 11
// 11(3) + 1000(8) = 1011
// 1011(11) + ---(48) = ----

// 1010 ^ = 0101