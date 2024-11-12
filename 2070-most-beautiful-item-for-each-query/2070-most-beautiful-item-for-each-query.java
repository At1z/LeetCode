import java.util.*;

class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> Integer.compare(a[0], b[0]));
        TreeMap<Integer, Integer> resultMap = new TreeMap<>();
        
        int maxBeauty = 0;
        for (int[] item : items) {
            int price = item[0];
            int beauty = item[1];
            maxBeauty = Math.max(maxBeauty, beauty);
            resultMap.put(price, maxBeauty);
        }
        int[] results = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            Integer closestPrice = resultMap.floorKey(queries[i]);
            if (closestPrice != null) {
                results[i] = resultMap.get(closestPrice);
            } else {
                results[i] = 0;
            }
        }
        
        return results;
    }
}
