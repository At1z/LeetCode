
class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));

        int n = robot.size();
        int m = factory.length;
        Long[][] dp = new Long[n][m];

        return assignRobots(robot, factory, 0, 0, dp);
    }

    private long assignRobots(List<Integer> robot, int[][] factory, int robotIdx, int factoryIdx, Long[][] dp) {
        if (robotIdx == robot.size()) return 0;
        if (factoryIdx == factory.length) return Long.MAX_VALUE / 2; // Use a safe large value to avoid overflow
        if (dp[robotIdx][factoryIdx] != null) return dp[robotIdx][factoryIdx];

        long minDistance = assignRobots(robot, factory, robotIdx, factoryIdx + 1, dp);

        long totalDistance = 0;
        for (int k = 0; k < factory[factoryIdx][1] && robotIdx + k < robot.size(); k++) {
            totalDistance += Math.abs((long) robot.get(robotIdx + k) - factory[factoryIdx][0]);
            minDistance = Math.min(minDistance, totalDistance + assignRobots(robot, factory, robotIdx + k + 1, factoryIdx + 1, dp));
        }

        dp[robotIdx][factoryIdx] = minDistance;
        return minDistance;
    }
}
