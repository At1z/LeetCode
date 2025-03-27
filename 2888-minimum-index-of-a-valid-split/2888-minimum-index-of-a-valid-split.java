class Solution {
    public int minimumIndex(List<Integer> nums) {
        if (nums == null || nums.isEmpty()) {
            return -1;
        }
        
        int mostFrequent = findMostFrequent(nums, 0, nums.size());
        int count = 0;
        
        for (int num : nums) {
            if (num == mostFrequent) {
                count++;
            }
        }
        
        int leftCount = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == mostFrequent) {
                leftCount++;
            }
            
            if (leftCount * 2 > (i + 1) && (count - leftCount) * 2 > (nums.size() - (i + 1))) {
                return i;
            }
        }
        
        return -1;
    }

    private static int findMostFrequent(List<Integer> nums, int start, int end) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i = start; i < end; i++) {
            frequencyMap.put(nums.get(i), frequencyMap.getOrDefault(nums.get(i), 0) + 1);
        }

        int maxCount = 0;
        int mostFrequent = -1;
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFrequent = entry.getKey();
            }
        }
        
        return mostFrequent;
    }
}
