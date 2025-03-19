class Solution {
    public int minOperations(int[] nums) {
        int l = 0;
        int r = 0;
        int counterOfOperations = 0;
        while(r < nums.length){
            while(r < nums.length && r - l < 2){
                r += 1;
            }
            if(r == nums.length){
                break;
            }
            if(nums[l] == 0){
                counterOfOperations += 1;
                int curL = l;
                while(curL < nums.length && curL != l + 3){
                    if(nums[curL] == 0){
                        nums[curL] = 1;
                    }else{
                        nums[curL] = 0;
                    }
                    curL += 1;
                }
            }
            l += 1;
        }
        for(int i = nums.length - 4; i < nums.length; i++){
            if(i >= 0 && nums[i] != 1){
                return -1;
            }
        }
        return counterOfOperations;
    }
}