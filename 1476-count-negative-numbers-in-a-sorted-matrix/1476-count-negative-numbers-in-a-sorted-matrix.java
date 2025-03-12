class Solution {
    public int countNegatives(int[][] grid) {
        int res = 0;
        for(int[] nums:grid){
            res += nums.length - firstNegativeValue(nums);
        }
        return res;
    }

    public int firstNegativeValue(int[] nums){
        int l = 0, r = nums.length - 1, index = nums.length;
        while(l <= r){
            int mid = l + (r - l)/2;
            if(nums[mid] >= 0){
                l = mid + 1;
            }else{
                index = mid;
                r = mid - 1;
            }
        }
        return index;
    }
}