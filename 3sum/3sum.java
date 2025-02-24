class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //[-1,0,1,2,-1,-4,3]
        Arrays.sort(nums); 
        //[-4,-1,-1,0,1,2,3]
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int l = i + 1;
            int h = nums.length - 1;
            while(l < h){
                if((nums[i] + nums[l] + nums[h]) == 0){
                    res.add(Arrays.asList(nums[i], nums[l], nums[h]));
                    while(h > l && nums[h] == nums[h-1]){
                        h -= 1;
                    }
                    while(h > l && nums[l] == nums[l+1]){
                        l += 1;
                    }
                    l += 1;
                    h -= 1;
                }else if((nums[i] + nums[l] + nums[h]) > 0){
                    h -= 1;
                }
                else{
                    l += 1;
                }
            }
        }
        return res;
    }
}