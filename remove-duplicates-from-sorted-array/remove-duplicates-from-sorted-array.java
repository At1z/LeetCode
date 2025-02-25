class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0; i < nums.length; i++){
            if(!seen.contains(nums[i])){
                minHeap.add(nums[i]);
                seen.add(nums[i]);
            }
        }
        int index = 0;
        while(!minHeap.isEmpty()){
            nums[index++] = minHeap.poll();
        }
        return seen.size();
    }
}