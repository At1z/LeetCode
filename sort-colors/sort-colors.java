class Solution {
    public void sortColors(int[] nums) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        for(int i: nums){
            maxHeap.add(i);
        }
        int index = 0;
        while(!maxHeap.isEmpty()){
            nums[index++] = maxHeap.poll();
        }
    }
}