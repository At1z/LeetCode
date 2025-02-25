class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][];
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> res = new ArrayList<>();
        int[] curInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] nextInterval = intervals[i];

            if (curInterval[1] >= nextInterval[0]) { 
                curInterval[1] = Math.max(curInterval[1], nextInterval[1]);
            } else { 
                res.add(curInterval);
                curInterval = nextInterval;
            }
        }

        res.add(curInterval);

        return res.toArray(new int[0][]);
    }
}
