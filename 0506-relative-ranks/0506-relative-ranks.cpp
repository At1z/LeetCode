class Solution {
public:
    vector<string> findRelativeRanks(vector<int>& score) {
        vector<int> copyScore = score;
        map<int, int> mapOfIndex;
        vector<string> res;

        std::sort(copyScore.begin(), copyScore.end(), std::greater<int>());

        for (int i = 0; i < copyScore.size(); i++) {
            mapOfIndex[copyScore[i]] = i + 1; 
        }

        for (int sc : score) {
            int rank = mapOfIndex[sc];
            if (rank == 1) {
                res.push_back("Gold Medal");
            } else if (rank == 2) {
                res.push_back("Silver Medal");
            } else if (rank == 3) {
                res.push_back("Bronze Medal");
            } else {
                res.push_back(std::to_string(rank));
            }
        }

        return res;
    }
};