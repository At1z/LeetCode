import java.util.*;

class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        int n = events.length;
        int[] dp = new int[n];
        dp[0] = events[0][2];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], events[i][2]);
        }
        int maxVal = 0;
        for (int i = 0; i < n; i++) {
            int lastNonOverlap = binarySearch(events, i);
            if (lastNonOverlap != -1) {
                maxVal = Math.max(maxVal, events[i][2] + dp[lastNonOverlap]);
            }
            maxVal = Math.max(maxVal, dp[i]);
        }
        return maxVal;
    }
    private int binarySearch(int[][] events, int index) {
        int left = 0, right = index - 1;
        int start = events[index][0];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (events[mid][1] < start) {
                if (events[mid + 1][1] < start) {
                    left = mid + 1;
                } else {
                    return mid;
                }
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
