class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //[-1,0,1,2,-1,-4,3]
        Arrays.sort(nums); 
        //[-4,-1,-1,0,1,2,3]
         Set<List<Integer>> seen = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int l = i + 1;
            int h = nums.length - 1;
            while(l < h){
                if((nums[i] + nums[l] + nums[h]) == 0){
                    List<Integer> triplet = Arrays.asList(nums[i], nums[l], nums[h]);
                    if (seen.add(triplet)) {
                        res.add(triplet);
                    }
                    l += 1;
                    h -= 1;
                    
                }
                while((nums[i] + nums[l] + nums[h]) > 0 && h > l){
                    h -= 1;
                } 
                while((nums[i] + nums[l] + nums[h]) < 0 && h > l){
                    l += 1;
                }
                
            }
        }
        return res;
    }
}