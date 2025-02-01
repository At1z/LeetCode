class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            res += nums[i];
            i += 1;
        }
        return res;
    }
}