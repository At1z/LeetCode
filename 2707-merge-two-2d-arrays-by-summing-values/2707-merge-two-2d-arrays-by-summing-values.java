class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> values = new TreeMap<>();
        for(int[] num : nums1){
            values.put(num[0], values.getOrDefault(num[0],0) + num[1]);
        }
        for(int[] num : nums2){
            values.put(num[0], values.getOrDefault(num[0],0) + num[1]);
        }
        int[][] res = new int[values.keySet().size()][2];
        int index = 0;
        for(int key : values.keySet()){
            res[index][0] = key;
            res[index++][1] = values.get(key);
        }
        return res;
    }
}