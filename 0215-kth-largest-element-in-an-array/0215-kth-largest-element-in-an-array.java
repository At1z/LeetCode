class Solution {
    public int findKthLargest(int[] nums, int k) {
        int heap = 0;
        PriorityQueue<Integer> maxheap = new PriorityQueue<>((a, b) -> b - a);
        for(int num : nums){
            maxheap.offer(num);
        }
        for(int i = 0; i < k; i++){
            heap = maxheap.poll();
        }

    return heap;
    }
}