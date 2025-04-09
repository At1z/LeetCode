class Solution {
public:
    bool repeatedSubstringPattern(string s) {
        for (int i = 1; i <= s.size() / 2; i++) {
            if (s.size() % i == 0) { 
                string curSubstring = s.substr(0, i); 
                string repeated = "";
                while (repeated.size() < s.size()) {
                    repeated += curSubstring;  
                }
                if (repeated == s) {
                    return true; 
                }
            }
        }
        return false;  
    }
};
