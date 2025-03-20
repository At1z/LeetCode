import java.util.*;

public class Solution {

    public int[] minimumCost(int n, int[][] edges, int[][] queries) {
        List<List<int[]>> adjList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>(2));
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(new int[] { edge[1], edge[2] });
            adjList.get(edge[1]).add(new int[] { edge[0], edge[2] });
        }

        boolean[] visited = new boolean[n];
        int[] components = new int[n];
        List<Integer> componentCost = new ArrayList<>(n);
        int componentId = 0;

        for (int node = 0; node < n; node++) {
            if (!visited[node]) {
                componentCost.add(
                    getComponentCost(
                        node,
                        adjList,
                        visited,
                        components,
                        componentId
                    )
                );
                componentId++;
            }
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];

            if (components[start] == components[end]) {
                answer[i] = componentCost.get(components[start]);
            } else {
                answer[i] = -1;
            }
        }

        return answer;
    }

    private int getComponentCost(
        int source,
        List<List<int[]>> adjList,
        boolean[] visited,
        int[] components,
        int componentId
    ) {
        Queue<Integer> nodesQueue = new LinkedList<>();
        int componentCost = Integer.MAX_VALUE;

        nodesQueue.offer(source);
        visited[source] = true;

        while (!nodesQueue.isEmpty()) {
            int node = nodesQueue.poll();
            components[node] = componentId;

            for (int[] neighbor : adjList.get(node)) {
                int weight = neighbor[1];
                componentCost &= weight;

                if (visited[neighbor[0]]) continue;
                visited[neighbor[0]] = true;
                nodesQueue.offer(neighbor[0]);
            }
        }

        return componentCost;
    }
}
