class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        std::sort(g.begin(), g.end());
        std::sort(s.begin(), s.end());
        int res = 0;
        int gIndex = g.size() - 1;
        int sIndex = s.size() - 1;
        while(gIndex >= 0 && sIndex >= 0){
            if(g[gIndex] <= s[sIndex]){
                sIndex -= 1;
                res += 1;
            }
            gIndex -= 1;
        }
        return res;
    }
};