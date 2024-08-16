class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        
        int minElement = arrays.get(0).get(0);
        int maxElement = arrays.get(0).get(arrays.get(0).size() - 1);
        int maxDistance = 0;
        
        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> currentList = arrays.get(i);
            int currentMin = currentList.get(0);
            int currentMax = currentList.get(currentList.size() - 1);
        
            maxDistance = Math.max(maxDistance, Math.abs(currentMax - minElement));
            maxDistance = Math.max(maxDistance, Math.abs(maxElement - currentMin));
            
            minElement = Math.min(minElement, currentMin);
            maxElement = Math.max(maxElement, currentMax);
        }
        
        return maxDistance;
    }
}
