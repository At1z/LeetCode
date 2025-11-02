class Solution {
    public int singleNumber(int[] nums) {
        int sum = 0;
        
        for(int num : nums){
            sum ^= num;
        }
        
        return sum;
    }
}