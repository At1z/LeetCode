class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] marker = new int[nums.length];
        permutations(new ArrayList<>(), nums, marker, res);
        return res;
    }
    public void permutations (List<Integer> cur, int[] nums, int[] marker ,List<List<Integer>> res){
        if(cur.size() == nums.length){
            res.add(new ArrayList<>(cur));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(marker[i] == 0){
                cur.add(nums[i]);
                marker[i] = 1;
            }else{
                continue;
            }
            permutations(cur, nums, marker, res);
            cur.remove(cur.size() - 1);
            marker[i] = 0; 
        }
    }
    
}