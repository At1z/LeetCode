class Solution {
public:
    vector<string> findRelativeRanks(vector<int>& score) {
    vector<int> copyScore = score;
    map<int,int> mapOfIndex;
    vector<string> res;
    std::sort(copyScore.begin(), copyScore.end());
    for(int i = 0; i < copyScore.size(); i++){
        mapOfIndex[copyScore[i]] = copyScore.size() - i  ;
    }
    for(int sc : score){
        string curRes = std::to_string(mapOfIndex[sc]);
        if(curRes == "1"){
            res.push_back("Gold Medal");
        }else if(curRes == "2"){
            res.push_back("Silver Medal");
        }else if (curRes == "3"){
            res.push_back("Bronze Medal");
        }else{
            res.push_back(curRes);
        }
    }


    return res;
    }
};