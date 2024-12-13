class Solution {
    public long findScore(int[] nums) {
        long res = 0;
        boolean[] visited = new boolean[nums.length];

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((arr1, arr2) -> {
            if (arr1[0] != arr2[0]) return arr1[0] - arr2[0];
            return arr1[1] - arr2[1];
        });

        for (int i = 0; i < nums.length; i++) {
            minHeap.add(new int[] { nums[i], i });
        }
        while (!minHeap.isEmpty()) {
            int[] element = minHeap.remove();
            //System.out.println(Arrays.toString(element));
            int number = element[0];
            int index = element[1];
            if (!visited[index]) {
                res += number;
                visited[index] = true;
                if (index - 1 >= 0) {
                    visited[index - 1] = true;
                }
                if (index + 1 < nums.length) {
                    visited[index + 1] = true;
                }
            }
        }

        return res;
    }
}