class Solution {
public:
    string compressedString(string word) {
        int i = 0;
        int counter = 1;
        stringstream ss;
        while(i < word.length()){
            if(i+1 == word.length()){
                ss << counter << word[i];
                break;
            }
            if (word[i] != word[i+1] || counter > 8){
                ss << counter << word[i];
                counter = 1;
            }else{
                counter += 1;
            }
            i++;
        }
        return ss.str();
    }
};