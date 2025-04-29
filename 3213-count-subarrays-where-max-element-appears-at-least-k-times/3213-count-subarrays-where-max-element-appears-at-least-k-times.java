class Solution {
    public long countSubarrays(int[] nums, int k) {
        long res = 0;
        int max = 0;
        int maxFrequency = 0;
        int r = 0;
        for(int num : nums){
            max = Math.max(max,num);
        }
        /*
        while(r < nums.length){
            while(r < nums.length && maxFrequency < k){
                if(nums[r] == max){
                    maxFrequency += 1;
                }
                r += 1;
            }
            if(maxFrequency == k){
                System.out.println(l + " " + (r) + " " + maxFrequency);
                res += nums.length - r + 1;
            }
            if(nums[l] == max){
                maxFrequency -= 1;
            }
            l += 1;
        }
        */
        for(int l = 0; l < nums.length; l++){
            while(r < nums.length && maxFrequency < k){
                if(nums[r] == max){
                    maxFrequency += 1;
                }
                r += 1;
            }
            if(maxFrequency == k){
                System.out.println(l + " " + (r) + " " + maxFrequency);
                res += nums.length - r + 1;
            }
            if(nums[l] == max){
                maxFrequency -= 1;
            }
        }
        return res;
    }
}