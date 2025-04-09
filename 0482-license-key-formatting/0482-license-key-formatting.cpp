class Solution {
public:
    string licenseKeyFormatting(string s, int k) {
        string licenseNoDashes = "";
        string res = "";
        for(int i = 0; i < s.size(); i++){
            if(s[i] != '-'){
                licenseNoDashes += std::toupper(s[i]);
            }
        }
        int freq = 0;
        int firstGroupSize = licenseNoDashes.size() % k;
        if(firstGroupSize != 0){
            res += licenseNoDashes.substr(0,firstGroupSize);
            freq = k;
        }
        
        for(int i = firstGroupSize; i < licenseNoDashes.size(); i++){
            if(freq == k){
                res += '-';
                freq = 0;
            }
            res += licenseNoDashes[i];
            freq += 1;
        }

        return res;
    }
};