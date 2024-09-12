class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            frequencyMap.put(nums[i], frequencyMap.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer> number = new ArrayList<>(frequencyMap.keySet());
        number.sort((a, b) -> frequencyMap.get(b) - frequencyMap.get(a));

        int [] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = number.get(i);
        }
        return res;
    }
}