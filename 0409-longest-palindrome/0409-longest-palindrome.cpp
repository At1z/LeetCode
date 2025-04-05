class Solution {
public:
    int longestPalindrome(string s) {
        int res = 0;
        int frequency[52] = {0}; 
        
        for(int i = 0; i < s.size(); i++) {
            char c = s[i];
            
            if (isupper(c)) {
                frequency[c - 'A' + 26] += 1; 
            } else {
                frequency[c - 'a'] += 1;  
            }
        }
        
        for(int i = 0; i < 52; i++) {
            if(frequency[i] % 2 == 0) {
                res += frequency[i];  
            } else {
                res += frequency[i] - 1;  
            }
        }
        return (res == s.size()) ? res : res + 1;
    }
};
