class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int[] maxLeftScore = new int[n];
        maxLeftScore[0] = values[0];
        int maxScore = 0;
        for (int i = 1; i < n; i++) {
            int currentRightScore = values[i] - i;
            maxScore = Math.max(
                maxScore,
                maxLeftScore[i - 1] + currentRightScore
            );
            int currentLeftScore = values[i] + i;
            maxLeftScore[i] = Math.max(maxLeftScore[i - 1], currentLeftScore);
        }

        return maxScore;
    }
}