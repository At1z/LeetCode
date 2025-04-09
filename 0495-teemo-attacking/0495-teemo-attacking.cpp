class Solution {
public:
    int findPoisonedDuration(vector<int>& timeSeries, int duration) {
        std::vector<std::vector<int>> intervals;
        std::vector<std::vector<int>> mergedIntervals;
        int res = 0;
        for (int i = 0; i < timeSeries.size(); i++) {
            intervals.push_back({timeSeries[i], timeSeries[i] + duration - 1});
        }
        /*
        std::sort(intervals.begin(), intervals.end(), [](const std::vector<int>& a, const std::vector<int>& b) {
            return a[1] < b[1];
        });
        */
        int start = intervals[0][0];
        int end = intervals[0][1];
        
        for (int i = 1; i < intervals.size(); i++) {
            int curStart = intervals[i][0];
            int curEnd = intervals[i][1];
            if(curStart <= end){
                end = max(end, curEnd);
            }else{
                mergedIntervals.push_back({start,end});
                start = curStart;
                end = curEnd;
            }
        }

        mergedIntervals.push_back({start,end});
        for(auto& mergedInterval : mergedIntervals){
            res += mergedInterval[1] - mergedInterval[0] + 1;
        }
        return res;
    }
};