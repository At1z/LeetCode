class Solution {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        tree = new ArrayList<>();
        bobPath = new HashMap<>();
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        findBobPath(bob, 0);
        Arrays.fill(visited, false);
        findAlicePath(0, 0, 0, amount);

        return maxIncome;
    }

    private Map<Integer, Integer> bobPath;
    private boolean[] visited;
    private List<List<Integer>> tree;
    private int maxIncome = Integer.MIN_VALUE;
    private boolean findBobPath(int sourceNode, int time) {
        bobPath.put(sourceNode, time);
        visited[sourceNode] = true;
        if (sourceNode == 0) {
            return true;
        }
        for (int adjacentNode : tree.get(sourceNode)) {
            if (!visited[adjacentNode] && findBobPath(adjacentNode, time + 1)) {
                return true;
            }
        }
        bobPath.remove(sourceNode);
        return false;
    }
    private void findAlicePath(
        int sourceNode,
        int time,
        int income,
        int[] amount
    ) {
        visited[sourceNode] = true;
        if (
            !bobPath.containsKey(sourceNode) || time < bobPath.get(sourceNode)
        ) {
            income += amount[sourceNode];
        }
        else if (time == bobPath.get(sourceNode)) {
            income += amount[sourceNode] / 2;
        }
        if (tree.get(sourceNode).size() == 1 && sourceNode != 0) {
            maxIncome = Math.max(maxIncome, income);
        }

        for (int adjacentNode : tree.get(sourceNode)) {
            if (!visited[adjacentNode]) {
                findAlicePath(adjacentNode, time + 1, income, amount);
            }
        }
    }
}