class Solution {
public:
    bool isCircularSentence(string sentence) {
        vector<string> sentences;
        istringstream stream(sentence);
        string word;
        
        while (stream >> word) {
            sentences.push_back(word);
        }
        
        bool res = true;

        if (sentences.size() == 1) {
            res = (sentences[0].front() == sentences[0].back());
        } else {
            for (size_t i = 1; i < sentences.size(); ++i) {
                if (sentences[i - 1].back() != sentences[i].front()) {
                    res = false;
                    break;
                }
            }
            if (res) {
                res = (sentences.back().back() == sentences[0].front());
            }
        }
        
        return res;
    }
};
