class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums.length < k){
            return -1;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i: nums){
            maxHeap.add(i);
        }
        for(int i = 0; i < k; i++){
            if(i == k-1){
                return maxHeap.poll();
            }
            maxHeap.poll();
        }
        return -1;
    }
}