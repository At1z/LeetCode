class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> position = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(position.containsKey(nums[i]) && (Math.abs(position.get(nums[i]) - i) <= k)){
                return true;
            }else{
                position.put(nums[i], i);
            }
        }
        return false;
    }
}