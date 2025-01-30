class Solution {
    public int magnificentSets(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        int[] parent = new int[n];
        int[] depth = new int[n];
        Arrays.fill(parent, -1);
        for (int[] edge : edges) {
            adjList.get(edge[0] - 1).add(edge[1] - 1);
            adjList.get(edge[1] - 1).add(edge[0] - 1);
            union(edge[0] - 1, edge[1] - 1, parent, depth);
        }

        Map<Integer, Integer> numOfGroupsForComponent = new HashMap<>();
        for (int node = 0; node < n; node++) {
            int numberOfGroups = getNumberOfGroups(adjList, node, n);
            if (numberOfGroups == -1) return -1;
            int rootNode = find(node, parent);
            numOfGroupsForComponent.put(
                rootNode,
                Math.max(
                    numOfGroupsForComponent.getOrDefault(rootNode, 0),
                    numberOfGroups
                )
            );
        }
        int totalNumberOfGroups = 0;
        for (int numberOfGroups : numOfGroupsForComponent.values()) {
            totalNumberOfGroups += numberOfGroups;
        }
        return totalNumberOfGroups;
    }
    private int getNumberOfGroups(
        List<List<Integer>> adjList,
        int srcNode,
        int n
    ) {
        Queue<Integer> nodesQueue = new LinkedList<>();
        int[] layerSeen = new int[n];
        Arrays.fill(layerSeen, -1);
        nodesQueue.offer(srcNode);
        layerSeen[srcNode] = 0;
        int deepestLayer = 0;
        while (!nodesQueue.isEmpty()) {
            int numOfNodesInLayer = nodesQueue.size();
            for (int i = 0; i < numOfNodesInLayer; i++) {
                int currentNode = nodesQueue.poll();
                for (int neighbor : adjList.get(currentNode)) {
                    if (layerSeen[neighbor] == -1) {
                        layerSeen[neighbor] = deepestLayer + 1;
                        nodesQueue.offer(neighbor);
                    } else {
                        if (layerSeen[neighbor] == deepestLayer) {
                            return -1;
                        }
                    }
                }
            }
            deepestLayer++;
        }
        return deepestLayer;
    }
    private int find(int node, int[] parent) {
        while (parent[node] != -1) node = parent[node];
        return node;
    }
    private void union(int node1, int node2, int[] parent, int[] depth) {
        node1 = find(node1, parent);
        node2 = find(node2, parent);
        if (node1 == node2) return;
        if (depth[node1] < depth[node2]) {
            int temp = node1;
            node1 = node2;
            node2 = temp;
        }
        parent[node2] = node1;
        if (depth[node1] == depth[node2]) depth[node1]++;
    }
}