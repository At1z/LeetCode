import java.util.*;

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            double prob = succProb[i];
            graph.get(a).add(new int[]{b, i});
            graph.get(b).add(new int[]{a, i});
        }

       
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
        pq.add(new double[]{start_node, 1.0});

       
        double[] maxProb = new double[n];
        maxProb[start_node] = 1.0;

       
        while (!pq.isEmpty()) {
            double[] current = pq.poll();
            int currentNode = (int) current[0];
            double currentProb = current[1];

            
            if (currentNode == end_node) {
                return currentProb;
            }

           
            for (int[] neighbor : graph.get(currentNode)) {
                int nextNode = neighbor[0];
                double edgeProb = succProb[neighbor[1]];
                double nextProb = currentProb * edgeProb;

              
                if (nextProb > maxProb[nextNode]) {
                    maxProb[nextNode] = nextProb;
                    pq.add(new double[]{nextNode, nextProb});
                }
            }
        }

        return 0.0;
    }
}
