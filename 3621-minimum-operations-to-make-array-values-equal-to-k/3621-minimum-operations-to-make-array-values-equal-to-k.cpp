class Solution {
public:
    int minOperations(vector<int>& nums, int k) {
        std::set<int> distinctNumber;
        for(int num : nums){
            if(num < k){
                return -1;
            }else if(distinctNumber.find(num) == distinctNumber.end() && num != k){
                distinctNumber.insert(num);
            }
        }
        return distinctNumber.size();
    }
};