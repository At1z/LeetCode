public class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
        }

        int[][] dp = new int[n][26];
        boolean[] visited = new boolean[n];
        boolean[] visiting = new boolean[n];
        int[] result = new int[1];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (dfs(i, graph, colors, visited, visiting, dp, result)) {
                    return -1;
                }
            }
        }

        return result[0];
    }

    private boolean dfs(int node, List<Integer>[] graph, String colors,
                        boolean[] visited, boolean[] visiting, int[][] dp, int[] result) {
        if (visiting[node]) return true;
        if (visited[node]) return false;

        visiting[node] = true;

        for (int neighbor : graph[node]) {
            if (dfs(neighbor, graph, colors, visited, visiting, dp, result)) {
                return true;
            }
            for (int c = 0; c < 26; c++) {
                dp[node][c] = Math.max(dp[node][c], dp[neighbor][c]);
            }
        }

        int colorIndex = colors.charAt(node) - 'a';
        dp[node][colorIndex]++;
        result[0] = Math.max(result[0], dp[node][colorIndex]);

        visiting[node] = false;
        visited[node] = true;

        return false;
    }
}
