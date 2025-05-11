class Solution {
    public int[] rearrangeArray(int[] nums) {
        int posIndex = 0;
        int negIndex = 0;
        int[] positive = new int[nums.length/2];
        int[] negative = new int[nums.length/2];
        int[] sorted = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                positive[posIndex] = nums[i];
                posIndex += 1;
            }else{
                negative[negIndex] = nums[i];
                negIndex += 1;
            }
        }
        int index = 0;
        for(int i = 0; i < nums.length; i+=2){
            sorted[i] = positive[index];
            sorted[i+1] = negative[index++];
        }
        return sorted;
    }
}