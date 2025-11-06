class Solution {
    int[] parents = null;
    Map<Integer,List<Integer>> edges = new HashMap<>();
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        List<Integer> result = new ArrayList<>();
        boolean[] online = new boolean[c + 1];
        Arrays.fill(online, true);
        parents = new int[c+1];

        for(int i = 1; i <= c; i++){
            parents[i] = i;
        }
        for(int i = 0; i < connections.length; i++){
            int[] cur = connections[i];
            int p1 = find(cur[0]);
            int p2 = find(cur[1]);
            int smaller = Math.min(p1,p2);
            int bigger = Math.max(p1,p2);
            parents[bigger] = smaller;
        }

        //System.out.println(Arrays.toString(parents));

        Map<Integer, PriorityQueue<Integer>> componentHeap = new HashMap<>();
        for (int station = 1; station <= c; station++) {
            int root = find(station);
            componentHeap.putIfAbsent(root, new PriorityQueue<>());
            componentHeap.get(root).offer(station);
        }


        for (int[] query : queries) {
            int type = query[0], x = query[1];

            if (type == 2) {
                online[x] = false;
            } else {
                if (online[x]) {
                    result.add(x);
                } else {
                    int root = find(x);
                    PriorityQueue<Integer> heap = componentHeap.get(root);

                    while (heap != null && !heap.isEmpty() && !online[heap.peek()]) {
                        heap.poll();
                    }

                    result.add((heap == null || heap.isEmpty()) ? -1 : heap.peek());
                }
            }
        }

        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
    return ans;
    }
    private int find(int x){
        if(x != parents[x]){
            x = find(parents[x]);
        }
        return x;
    }

}