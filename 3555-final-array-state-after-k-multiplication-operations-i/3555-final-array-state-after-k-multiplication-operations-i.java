class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((arr1,arr2)->{
            if (arr1[0] != arr2[0]) return arr1[0] - arr2[0];
            return arr1[1] - arr2[1];
        });
        for(int i = 0; i < nums.length; i++){
            minHeap.add(new int[]{nums[i],i});
        }
        while(k > 0){
            int[] temp = minHeap.poll();
            minHeap.add(new int[]{temp[0]*multiplier,temp[1]});
            k -= 1;
        }
        for(int i = 0; i < nums.length; i++){
            int[] temp = minHeap.poll();
            nums[temp[1]] = temp[0];
        }

        return nums;
    }
}