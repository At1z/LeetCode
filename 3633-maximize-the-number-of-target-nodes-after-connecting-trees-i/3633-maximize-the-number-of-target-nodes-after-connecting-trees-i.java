class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        Map<Integer, List<Integer>> graph1 = buildGraph(edges1);
        Map<Integer, List<Integer>> graph2 = buildGraph(edges2);
        int[] res = new int[graph1.size()];
        
        for (int node : graph1.keySet()) {
            int count = countPaths(graph1, node, k);
            res[node] = count;
        }

        int maxCount = 0;
        for (int node : graph2.keySet()) {
            int count = countPaths(graph2, node, k - 1);
            maxCount = Math.max(maxCount, count);
        }
        
        int addBaseNode = (k == 0)?1:2;
        for (int i = 0; i < res.length; i++) {
            res[i] += maxCount + addBaseNode;
        }

        return res; 
    }

    private Map<Integer, List<Integer>> buildGraph(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.computeIfAbsent(u, x -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, x -> new ArrayList<>()).add(u);
        }
        return graph;
    }

    private int countPaths(Map<Integer, List<Integer>> graph, int start, int maxDepth) {
        return dfsCount(graph, start, maxDepth, new HashSet<>());
    }

    private int dfsCount(Map<Integer, List<Integer>> graph, int current, int remainingDepth, Set<Integer> visited) {
        if (remainingDepth < 0) return 0;

        visited.add(current);
        int count = 0;

        if (remainingDepth > 0) {
            for (int neighbor : graph.getOrDefault(current, Collections.emptyList())) {
                if (!visited.contains(neighbor)) {
                    count += 1;
                    count += dfsCount(graph, neighbor, remainingDepth - 1, visited);
                }
            }
        }

        visited.remove(current);
        return count;
    }
}
