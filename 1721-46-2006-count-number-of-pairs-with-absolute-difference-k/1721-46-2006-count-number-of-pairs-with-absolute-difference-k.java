class Solution {
    public int countKDifference(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            freq.put(nums[i], freq.getOrDefault(nums[i],0) + 1);
        }
        for(int num : nums){
            res += freq.getOrDefault(num-k,0);
        }
        return res;
    }
}