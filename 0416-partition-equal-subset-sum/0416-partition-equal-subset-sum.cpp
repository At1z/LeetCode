
class Solution {
public:
    bool canPartition(vector<int>& nums) {
        int total = 0;
        for (int num : nums)
            total += num;

        if (total % 2 != 0)
            return false;

        int target = total / 2;
        int n = nums.size();
        vector<vector<int>> memo(n, vector<int>(target + 1, -1));

        return canFindSubset(nums, 0, 0, target, memo);
    }

private:
    bool canFindSubset(vector<int>& nums, int index, int currentSum, int target, vector<vector<int>>& memo) {
        if (currentSum == target)
            return true;
        if (currentSum > target || index >= nums.size())
            return false;

        if (memo[index][currentSum] != -1)
            return memo[index][currentSum] == 1;

        bool include = canFindSubset(nums, index + 1, currentSum + nums[index], target, memo);
        bool exclude = canFindSubset(nums, index + 1, currentSum, target, memo);

        memo[index][currentSum] = (include || exclude) ? 1 : 0;
        return memo[index][currentSum] == 1;
    }
};
