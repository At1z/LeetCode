class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int max = 0;
        int res = 0;
        for (int num : nums) {
            max |= num; 
        }

        res = dfs(nums, 0, 0, max); 
        return res;
    }

    private static int dfs(int[] nums, int index, int currentOr, int maxOr) {
        if (index == nums.length) {
            return currentOr == maxOr ? 1 : 0;
        }
        int include = dfs(nums, index + 1, currentOr | nums[index], maxOr);
        int exclude = dfs(nums, index + 1, currentOr, maxOr);
        return include + exclude;
    }
}