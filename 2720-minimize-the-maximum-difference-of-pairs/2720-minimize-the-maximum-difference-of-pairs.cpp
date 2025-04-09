class Solution {
public:
    int countValidPairs(vector<int>& nums, int threshold){
        int index = 0;
        int count = 0;
        while (index < nums.size() - 1) {
            if (nums[index + 1] - nums[index] <= threshold) {
                count++;
                index++;
            }
            index++;
        }
        return count;
    }

    int minimizeMax(vector<int>& nums, int p) {
        std::sort(nums.begin(),nums.end());
        int n = nums.size();
        int l = 0; 
        int r = nums[n - 1] - nums[0];
        while(l < r){
            int mid = l + (r-l)/2;
            if (countValidPairs(nums, mid) >= p) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
};