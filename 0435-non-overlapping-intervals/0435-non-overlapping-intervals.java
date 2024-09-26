import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        /*
        for(int[] tab : intervals) {
            System.out.println(Arrays.toString(tab));
        }
        */
        int end = intervals[0][1];
        int res = 0;

        for(int i = 1; i < intervals.length; i++) {
            int curStart = intervals[i][0];
            int curEnd = intervals[i][1];

            if (curStart < end) {
                res += 1;
            } else {
                end = curEnd;
            }
        }

        return res;
    }
}
