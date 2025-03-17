class Solution {
    public boolean divideArray(int[] nums) {
        HashMap<Integer,Integer> frequency = new HashMap<>();
        for(int num:nums){
            frequency.put(num, frequency.getOrDefault(num,0)+1);
        }
        for(int value : frequency.values()){
            if(value % 2 != 0){
                return false;
            }
        }
        return true;
    }
}