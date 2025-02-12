class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(long num:nums){
            pq.add(num);
        }
        int res = 0;
        while(!pq.isEmpty()){
            long first = pq.poll();
            if(first >= k){
                break;
            }else if(pq.size() > 0){
                long second = pq.poll();
                res += 1;
                long curAns = Math.min(first,second)* 2 + Math.max(first,second);
                pq.add(curAns);
           }
        }    
        return res;
    }
}