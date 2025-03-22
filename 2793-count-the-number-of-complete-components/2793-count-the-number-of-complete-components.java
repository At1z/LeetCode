class Solution {
    Map<Integer,List<Integer>> graph = new HashMap<>();
    int[] seen;

    public int countCompleteComponents(int n, int[][] edges) {
        int res = 0;
        for(int i=0;i<n;i++){
            graph.put(i ,new ArrayList<>());
        } 
        graphBuilder(edges);
        seen = new int[n];

        for(int node : graph.keySet()){
            if (seen[node] == 1){
                continue;
            }
            
            seen[node] = 1;
            Set<Integer> allNodes = new HashSet<>(graph.get(node));
            allNodes.add(node);

            if(isCompleted(graph.get(node), allNodes)){
                res += 1;
            }
        }
        return res + (n - Arrays.stream(seen).sum());
    }

    public boolean isCompleted(List<Integer> connections, Set<Integer> allNodes){
        int numberOfNodes = allNodes.size() - 1;

        for(int node : connections){
            List<Integer> curConnections = graph.get(node);
            if(numberOfNodes != curConnections.size()){
                return false;
            }
            
            for(int edge : curConnections){
                if(!allNodes.contains(edge) ){
                    seen[edge] = 1;
                    return false;
                }
            }

            seen[node] = 1;
        }
        return true;
    }

    public void graphBuilder(int[][] edges){
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
    }
}