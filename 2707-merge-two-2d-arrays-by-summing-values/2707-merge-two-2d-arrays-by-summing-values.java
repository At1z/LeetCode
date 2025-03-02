class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int n1 = nums1.length - 1;
        int n2 = nums2.length - 1;
        List<int[]> merge = new ArrayList<>();
        int p1 = 0;
        int p2 = 0;

        while (p1 <= n1 && p2 <= n2) {
            if (nums1[p1][0] == nums2[p2][0]) {
                merge.add(new int[]{nums1[p1][0], nums1[p1][1] + nums2[p2][1]}); // Fixed the issue
                p1 += 1;
                p2 += 1;
            } else if (nums1[p1][0] < nums2[p2][0]) {
                merge.add(nums1[p1]);
                p1 += 1;
            } else {
                merge.add(nums2[p2]);
                p2 += 1;
            }
        }

        while (p1 <= n1) {
            merge.add(nums1[p1]);
            p1 += 1;
        }

        while (p2 <= n2) {
            merge.add(nums2[p2]);
            p2 += 1;
        }

        return merge.toArray(new int[merge.size()][]);
        /*
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
        */
    }
}