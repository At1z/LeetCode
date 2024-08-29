class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length; 

        parent = new int[20000];
        rank = new int[20000];

        for (int i = 0; i < 20000; i++) {
            parent[i] = i;
        }

        for (int[] stone : stones) {
            union(stone[0], stone[1] + 10001);
        }

        int numOfComponents = 0;
        Map<Integer, Boolean> seen = new HashMap<>();
        for (int[] stone : stones) {
            int root = find(stone[0]);
            if (!seen.containsKey(root)) {
                seen.put(root, true);
                numOfComponents++;
            }
        }

        return n - numOfComponents;
    }
    private int[] parent;
    private int[] rank;

    
    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

}