class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        Arrays.fill(dist1, -1);
        Arrays.fill(dist2, -1);

        dfs(0, dist1, edges, node1, new boolean[n]);
        dfs(0, dist2, edges, node2, new boolean[n]);

        int result = -1;
        int minDist = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (dist1[i] != -1 && dist2[i] != -1) {
                int maxDist = Math.max(dist1[i], dist2[i]);
                if (maxDist < minDist) {
                    minDist = maxDist;
                    result = i;
                }
            }
        }

        return result;
    }

    private void dfs(int dist, int[] distances, int[] edges, int node, boolean[] seen) {
        if (node == -1 || seen[node]) return;

        seen[node] = true;
        distances[node] = dist;

        dfs(dist + 1, distances, edges, edges[node], seen);
    }
}