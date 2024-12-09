class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int res = 100000;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                res = Math.min(Math.abs(i - start), res);
            }
        }
        return res;
    }
}