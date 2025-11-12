class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> seen = new HashMap<>();
        int curMod = 0;
        seen.put(0,-1);
        for(int i = 0; i < nums.length; i++){
            curMod = (curMod + nums[i]) % k;
            if(seen.containsKey(curMod)){
                int start = seen.get(curMod);
                if(i - start > 1){
                    //System.out.println(start + 1 + " " + i);
                    return true;
                }
            }else{
                seen.put(curMod, i);
            }
            //System.out.println(seen);
        }

        return false;
    }
}