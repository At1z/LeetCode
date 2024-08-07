class Solution {
    public int searchInsert(int[] nums, int target) {
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            if(target>nums[nums.length-1]){
                index = nums.length;
                break;
            }
            if(nums[i] == target){
                index = i;
                break;
            }
            if(nums[i]>target){
                index = i;
                break;
            }
        }
      return index;  
    }
}