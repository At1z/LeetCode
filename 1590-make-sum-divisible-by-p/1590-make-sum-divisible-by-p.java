class Solution {
    public int minSubarray(int[] nums, int p) {
        long total = 0;
        for (int num : nums) total += num;
        
        long mod = total % p;
        if (mod == 0) return 0;

        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, -1);
        long prefix = 0;
        int res = nums.length;

        for (int i = 0; i < nums.length; i++) {
            prefix = (prefix + nums[i]) % p;
            long need = (prefix - mod + p) % p;

            if (map.containsKey(need)) {
                res = Math.min(res, i - map.get(need));
            }
            map.put(prefix, i);
        }

        return res == nums.length ? -1 : res;
    }
}
