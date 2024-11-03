class Solution {
public:
    bool rotateString(string s, string goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        string dS = s + s;
        return dS.find(goal) != string::npos;
    }
};
