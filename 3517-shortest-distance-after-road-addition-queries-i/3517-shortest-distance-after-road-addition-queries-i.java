class Solution {
    public int findMinDistance(List<List<Integer>> adjList, int n) {
        int[] dp = new int[n];
        dp[n - 1] = 0;
        for (int currentNode = n - 2; currentNode >= 0; currentNode--) {
            int minDistance = n;
            for (int neighbor : adjList.get(currentNode)) {
                minDistance = Math.min(minDistance, dp[neighbor] + 1);
            }
            dp[currentNode] = minDistance; 
        }
        return dp[0];
    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<Integer> answer = new ArrayList<>();
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            adjList.get(i).add(i + 1);
        }
        for (int[] road : queries) {
            int u = road[0];
            int v = road[1];
            adjList.get(u).add(v); 
            answer.add(findMinDistance(adjList, n));
        }
        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result; 
    }
}
