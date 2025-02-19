class Solution {
    public int findCenter(int[][] edges) {
        Map<Integer,Integer> connections = new HashMap<>();
        for(int[] edge : edges){
            connections.put(edge[0], connections.getOrDefault(edge[0],0) + 1);
            connections.put(edge[1], connections.getOrDefault(edge[1],0) + 1);
        }
        for(int node : connections.keySet()){
            if(connections.get(node) == edges.length){
                return node;
            }
        }
        return -1;
    }
}