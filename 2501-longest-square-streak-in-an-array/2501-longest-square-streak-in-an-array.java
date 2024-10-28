class Solution {
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        Set<Long> set = new HashSet<Long>();
        for(long num:nums){
            set.add(num);
        }
        int maxSq = 1;
        for(int i = 0; i < nums.length; i++){
            long num = nums[i];
            int curSq = 1;
            while(set.contains(num*num)){
                curSq += 1;
                num = num*num;
                set.remove(num);
            }
            maxSq = Math.max(maxSq,curSq);
            if(maxSq == 5){
                return maxSq;
            }
        }
        
        return maxSq == 1 ? -1 : maxSq;
    }
}