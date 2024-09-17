class Solution {
     public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                result.add(num); 
                map.put(num, map.get(num) - 1);
            }
        }
        
        int[] intersection = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            intersection[i] = result.get(i);
        }
        
        return intersection;
    }
}