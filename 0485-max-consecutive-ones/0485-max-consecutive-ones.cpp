class Solution {
public:
    int findMaxConsecutiveOnes(vector<int>& nums) {
       int res = 0;
       int l = 0;
       int r = 0;
       while(r < nums.size()){
            while(r < nums.size() && nums[r] == 1){
                r += 1;
            }
            res = max(res, r - l);
            r += 1;
            l = r;
       }
       return res; 
    }
};