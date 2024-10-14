class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long res = 0;
        for(int i:nums){
            pq.add(i);
        }
        int i = 0;
        while(k > 0){
            double curPeek = pq.poll();
            res += (long) curPeek;
            pq.offer((int) Math.ceil(curPeek / 3));
            k--;
        }
    return res;
    }
}