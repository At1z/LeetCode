class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;
        int q = queries.length;
        int[] res = new int[q];
        
        // Process queries and store indices to handle them in order
        List<int[]>[] queryList = new List[n];
        for (int i = 0; i < n; i++) {
            queryList[i] = new ArrayList<>();
        }
        
        // Group queries by their maximum position
        for (int i = 0; i < q; i++) {
            int a = Math.min(queries[i][0], queries[i][1]);
            int b = Math.max(queries[i][0], queries[i][1]);
            
            // Handle special case when same index
            if (a == b) {
                res[i] = b;
                continue;
            }
            
            // If right building is taller than left building
            if (heights[b] > heights[a]) {
                res[i] = b;
                continue;
            }
            
            queryList[b].add(new int[]{a, i}); // store original query index
        }
        
        // Use TreeMap to store future buildings (height -> index)
        TreeMap<Integer, Integer> futureBuildings = new TreeMap<>();
        
        // Process from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Add current building to future buildings
            while (!futureBuildings.isEmpty() && 
                   futureBuildings.firstKey() <= heights[i]) {
                futureBuildings.pollFirstEntry();
            }
            futureBuildings.put(heights[i], i);
            
            // Process queries where b == i
            for (int[] query : queryList[i]) {
                int a = query[0];
                int queryIndex = query[1];
                
                // Need to find building higher than both a and i
                int requiredHeight = Math.max(heights[a], heights[i]) + 1;
                Map.Entry<Integer, Integer> entry = futureBuildings.ceilingEntry(requiredHeight);
                
                if (entry != null) {
                    res[queryIndex] = entry.getValue();
                } else {
                    res[queryIndex] = -1;
                }
            }
        }
        
        return res;
    }
}