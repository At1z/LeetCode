class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long res = 0;
        long cSum = 0;
        int front = 0;
        int back = 0;
        int n = nums.length;
        HashMap<Integer, Integer> numIndex = new HashMap<>();
        while(back < n){
            int cNum = nums[back];
            int lastIndex = numIndex.getOrDefault(cNum,-1);
            while(front <= lastIndex || back - front + 1 > k){ // sprwdzamy czy cNum jest w ostatnich k iteracjach albo czy Mapa nie jest za długa
                cSum -= nums[front];
                front += 1;
            }
            cSum += nums[back];
            numIndex.put(cNum,back);
            if(back - front + 1== k){
                res = Math.max(res,cSum);
            } 
            back += 1;
        }
        return res;
    }
}