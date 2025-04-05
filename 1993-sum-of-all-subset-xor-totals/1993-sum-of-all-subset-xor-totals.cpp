class Solution {
public:
    int subsetXORSum(vector<int>& nums) {
        vector<int> xorValues;
        backtracking(xorValues, nums, 0, nums.size(), 0);
        int res = 0;
        for (int val : xorValues) {
            res += val;
        }
        return res;
    }

public:
    void backtracking(vector<int>& xorValues, vector<int>& nums, int index, int size, int xorVal) {
        if (index > size - 1) {
            xorValues.push_back(xorVal);
            return;
        }
        backtracking(xorValues, nums, index + 1, size, xorVal ^ nums[index]);
        backtracking(xorValues, nums, index + 1, size, xorVal);
    }
};
