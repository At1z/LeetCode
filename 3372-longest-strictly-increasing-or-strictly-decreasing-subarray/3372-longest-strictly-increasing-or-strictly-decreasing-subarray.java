class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int inc = 1;
        int dec = 1;
        int cInc = 1;
        int cDec = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i-1]){
                cInc += 1;
                cDec = 1;
            }else if(nums[i] < nums[i-1]){
                cDec += 1;
                cInc = 1;
            }else{
                cInc = 1;
                cDec = 1;
            }
            inc = Math.max(inc,cInc);
            dec = Math.max(dec,cDec);
        }
        int res = Math.max(inc,dec);
        return res;
    }
}