class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long res = 0;
        for (int gift : gifts) {
            maxHeap.add(gift);
        }
        while (k > 0) {
            double largest = maxHeap.poll();
            int flooredSqrt = (int) Math.floor(Math.sqrt(largest));
            if (flooredSqrt > 0) { 
                maxHeap.add(flooredSqrt);
            }
            k -= 1;
        }
        while(!maxHeap.isEmpty()){
            res += maxHeap.poll();
        }
        return res;
    }
}
