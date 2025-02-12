class Solution {
    public int maximumSum(int[] nums) {
        int[] asc = new int[nums.length];
        Map<Integer,int[]> freq = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            String num = Integer.toString(nums[i]);
            for(char c:num.toCharArray()){
                asc[i] += c -'0';
            }
        }
        int res = -1;
        for(int i = 0; i < asc.length; i++){
            if (!freq.containsKey(asc[i])) {
                freq.put(asc[i], new int[]{nums[i], -1});
            }else {
                int[] pair = freq.get(asc[i]);
                if (nums[i] > pair[0]) {
                    pair[1] = pair[0]; 
                    pair[0] = nums[i];
                } else if (nums[i] > pair[1]) {
                    pair[1] = nums[i];
                }
                if (pair[1] != -1) {
                    res = Math.max(res, pair[0] + pair[1]);
                }
            }
        }
          
        return res;
    }
}