#include <iostream>
#include <vector>
#include <queue>
#include <set>

class Solution {
public:
    int thirdMax(std::vector<int>& nums) {
        std::priority_queue<int> maxHeap;
        std::set<int> seen;
        
        for (int num : nums) {
            if (seen.find(num) == seen.end()) {  
                maxHeap.push(num);
                seen.insert(num);
            }
        }
    
        if (maxHeap.size() < 3) {
            return maxHeap.top();
        }
        
        maxHeap.pop();
        maxHeap.pop();
        return maxHeap.top();
    }
};
