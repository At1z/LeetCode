class Solution {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals,(a,b)-> Integer.compare(a[0],b[0]));
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int[] interval:intervals){
            if(!heap.isEmpty() && heap.peek() < interval[0]){
             heap.poll(); 
            }
            heap.offer(interval[1]);
        }
        return heap.size();
        /*
        Arrays.sort(intervals,(a,b)-> Integer.compare(a[0],b[0]));
        for(int[] tab:intervals){
            System.out.println(Arrays.toString(tab));
        }
        int n = intervals.length;
        boolean[] used = new boolean[n];
        Arrays.fill(used, false);
        int res = 0;

        for(int i = 0; i < n; i++){
            if(used[i] == true ){
                    continue;
            }
            used[i] = true;
            int curInterval = intervals[i][1];
            for(int j = 0; j < n; j++){
                if(used[j] == true){
                    continue;
                }
                if(curInterval < intervals[j][0]){
                    curInterval = intervals[j][1];
                    used[j] = true;
                }
            }
            res += 1;
        }
    
    return res;
    */
    }
}