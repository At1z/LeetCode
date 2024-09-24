class Solution {
    public int missingInteger(int[] nums) {
        Set<Integer> numsSet = new HashSet<Integer>();
        for(int num: nums){
            numsSet.add(num);
        }
        int minVal = nums[0];
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i+1] == nums[i] + 1){
                minVal += nums[i+1];
            }else{
                break;
            }
        }
        while(numsSet.contains(minVal)){
            minVal += 1;
        }
        return minVal;
    }
}