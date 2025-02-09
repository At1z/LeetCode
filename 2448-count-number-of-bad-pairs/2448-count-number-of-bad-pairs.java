class Solution {
    public long countBadPairs(int[] nums) {
        Map<Integer,Integer> freq = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            freq.put(i - nums[i],freq.getOrDefault(i - nums[i], 0)+1);
        }
        long res = 0;
        for (int f : freq.values()) {
            if (f > 1) {
                res += (long) f * (f - 1) / 2;
            }
        }
        long totalPairs = (long) nums.length * (nums.length - 1) / 2;
        return totalPairs - res;
    }
}

// 0 0 1 0 2 4 0 3 0