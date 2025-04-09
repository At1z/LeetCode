class Solution {
public:
    vector<int> nextGreaterElement(vector<int>& nums1, vector<int>& nums2) {
        std::unordered_map<int, int> indexMap;
        std::vector<int> res;

        for (int i = 0; i < nums2.size(); ++i) {
            indexMap[nums2[i]] = i;
        }

        for (int num : nums1) {
            int idx = indexMap[num];
            int nextGreater = -1;
            
            for (int j = idx + 1; j < nums2.size(); ++j) {
                if (nums2[j] > num) {
                    nextGreater = nums2[j];
                    break;
                }
            }

            res.push_back(nextGreater);
        }

        return res;
    }
};
