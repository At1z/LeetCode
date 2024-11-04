class Solution {
public:
    string compressedString(string word) {
        int i = 0;
        int counter = 1;
        string res = "";
        while (i < word.length()) {
            if (i + 1 == word.length() || word[i] != word[i + 1] || counter > 8) {
                res += to_string(counter) + word[i];
                counter = 1;
            } else {
                counter += 1;
            }
            i++;
        }
        return res;
    }
};