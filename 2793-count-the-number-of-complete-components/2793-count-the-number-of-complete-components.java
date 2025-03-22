class Solution {
    Map<Integer,List<Integer>> graph = new HashMap<>();
    Set<Integer> seen = new HashSet<>();
    public int countCompleteComponents(int n, int[][] edges) {
        int res = 0;
        graphBuilder(edges);
        for(int node : graph.keySet()){
            if(seen.contains(node)){
                continue;
            }
            seen.add(node);
            Set<Integer> allNodes = new HashSet<>(graph.get(node));
            allNodes.add(node);
            if(isCompleted(graph.get(node), allNodes.size() - 1, allNodes )){
                res += 1;
            }
        }
        return res + n - seen.size();
    }

    public void graphBuilder(int[][] edges){
        for(int[] edge : edges){
            graph.putIfAbsent(edge[0],new ArrayList<>());
            graph.putIfAbsent(edge[1],new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
    }

    public boolean isCompleted(List<Integer> connections, int numberOfNodes, Set<Integer> allNodes){
        for(int node : connections){
            List<Integer> curConnections = graph.get(node);
            if(numberOfNodes != curConnections.size()){
                return false;
            }
            for(int edge : curConnections){
                if(!allNodes.contains(edge)){
                    seen.add(edge);
                    return false;
                }
            }
            seen.add(node);
        }
        return true;
    }
}