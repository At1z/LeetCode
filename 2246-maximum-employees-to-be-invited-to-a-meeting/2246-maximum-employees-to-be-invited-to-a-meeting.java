class Solution {

    private int calculateDistance(int start, Set<Integer> visitedSet, List<List<Integer>> graph) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { start, 0 });
        int maxDist = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int distance = current[1];
            for (int neighbor : graph.get(node)) {
                if (visitedSet.contains(neighbor)) continue;
                visitedSet.add(neighbor);
                queue.offer(new int[] { neighbor, distance + 1 });
                maxDist = Math.max(maxDist, distance + 1);
            }
        }
        return maxDist;
    }

    public int maximumInvitations(int[] favorites) {
        int n = favorites.length;
        List<List<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            graph.get(favorites[i]).add(i);
        }

        int maxCycle = 0;
        int pairCycleCount = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                Map<Integer, Integer> distanceMap = new HashMap<>();
                int current = i;
                int dist = 0;
                while (true) {
                    if (visited[current]) break;
                    visited[current] = true;
                    distanceMap.put(current, dist++);
                    int next = favorites[current];

                    if (distanceMap.containsKey(next)) {
                        int cycleSize = dist - distanceMap.get(next);
                        maxCycle = Math.max(maxCycle, cycleSize);

                        if (cycleSize == 2) {
                            Set<Integer> visitedNodes = new HashSet<>();
                            visitedNodes.add(current);
                            visitedNodes.add(next);
                            pairCycleCount +=
                                2 +
                                calculateDistance(next, visitedNodes, graph) +
                                calculateDistance(current, visitedNodes, graph);
                        }
                        break;
                    }
                    current = next;
                }
            }
        }
        return Math.max(maxCycle, pairCycleCount);
    }
}
