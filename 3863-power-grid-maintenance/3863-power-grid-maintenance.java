class Solution {
    int[] parents = null;
    Map<Integer,List<Integer>> edges = new HashMap<>();
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        List<Integer> result = new ArrayList<>();
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

        boolean[] online = new boolean[c + 1];
        int[] offlineCounts = new int[c + 1];
        Arrays.fill(online, true);
        Map<Integer, Integer> minimumOnlineStations = new HashMap<>();
        for (int[] q : queries) {
            int op = q[0];
            int x = q[1];
            if (op == 2) {
                online[x] = false;
                offlineCounts[x]++;
            }
        }

        //System.out.println(Arrays.toString(online));
        for (int i = 1; i <= c; i++) {
            int root = find(i);
            if (!minimumOnlineStations.containsKey(root)) {
                minimumOnlineStations.put(root, -1);
            }
            int station = minimumOnlineStations.get(root);
            if (online[i]) {
                if (station == -1 || station > i) {
                    minimumOnlineStations.put(root, i);
                }
            }
        }
        //System.out.println(minimumOnlineStations);
        
        for (int i = queries.length - 1; i >= 0; i--) {
            int op = queries[i][0];
            int x = queries[i][1];
            int root = find(x);
            int station = minimumOnlineStations.get(root);

            if (op == 1) {
                if (online[x]) {
                    result.add(x);
                } else {
                    result.add(station);
                }
            }

            if (op == 2) {
                if (offlineCounts[x] > 1) {
                    offlineCounts[x]--;
                } else {
                    online[x] = true;
                    if (station == -1 || station > x) {
                        minimumOnlineStations.put(root, x);
                    }
                }
            }
        }
        Collections.reverse(result);
        //System.out.println(result);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private int find(int x){
        if(x != parents[x]){
            x = find(parents[x]);
        }
        return x;
    }

}