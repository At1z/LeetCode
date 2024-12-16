class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        int lSum = 0;
        for(int i:nums){
            sum += i;
        }

        for(int i = 0; i < nums.length; i++){
            if(lSum*2 == (sum - nums[i])){
                return i;
            }
            lSum += nums[i];
        }   
        return -1;
    }
}