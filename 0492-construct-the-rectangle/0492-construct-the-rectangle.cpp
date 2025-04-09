class Solution {
public:
    vector<vector<int>> getFactorPairs(int x) {
        vector<vector<int>> result;
        for (int a = 1; a * a <= x; ++a) {
            if (x % a == 0) {
                int b = x / a;
                if(a >= b ){
                    result.push_back({a, b});
                }
                if (a != b) {
                    result.push_back({b, a}); 
                }
            }
        }
        return result;
    }

    vector<int> constructRectangle(int area) {
        vector<vector<int>> factors = getFactorPairs(area);
        return factors[factors.size() - 1]; 
    }
};
