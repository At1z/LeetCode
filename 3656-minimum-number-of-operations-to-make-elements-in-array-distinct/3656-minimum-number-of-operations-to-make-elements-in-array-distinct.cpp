class Solution {
public:
    int minimumOperations(vector<int>& nums) {
        map<int, int> frequencyMap;
        set<int> duplicates;
        int res = 0;

        for (int num : nums) {
            frequencyMap[num]++;
        }

        for (const auto& entry : frequencyMap) {
            if (entry.second > 1) {
                duplicates.insert(entry.first);
            }
        }
        while (!duplicates.empty()) {
            for (int i = 0; i < 3 && i < nums.size(); i++) {
                int num = nums[i];
                frequencyMap[num]--;
                if (frequencyMap[num] == 1) {
                    duplicates.erase(num);
                }
            }
            res++;
            nums.erase(nums.begin(), nums.begin() + min(3, (int)nums.size()));
        }

        return res;
    }
};

