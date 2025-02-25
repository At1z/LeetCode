class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
         subset(0, new ArrayList<>(), res, nums);
        return res;
    }
    public void subset(int index, List<Integer> cur, List<List<Integer>> res, int[] nums){
        if(index == nums.length){
            res.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[index]);
        subset(index + 1, cur, res, nums);
        cur.remove(cur.size()-1);
        subset(index + 1, cur, res, nums);
        
    }
}