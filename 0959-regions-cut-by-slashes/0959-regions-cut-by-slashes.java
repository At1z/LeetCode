//https://www.youtube.com/watch?v=tIZkh7mpIDo

class Solution {
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

    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int size = n * n * 4;
        parent = new int[size];
        rank = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int index = 4 * (i * n + j);
                char c = grid[i].charAt(j);

                if (c == '/') {
                    union(index + 0, index + 3);
                    union(index + 1, index + 2);
                } else if (c == '\\') {
                    union(index + 0, index + 1);
                    union(index + 2, index + 3);
                } else {
                    union(index + 0, index + 1);
                    union(index + 1, index + 2);
                    union(index + 2, index + 3);
                }

                if (j + 1 < n) {
                    union(index + 1, 4 * (i * n + (j + 1)) + 3);
                }
                if (i + 1 < n) {
                    union(index + 2, 4 * ((i + 1) * n + j) + 0);
                }
            }
        }

        int regions = 0;
        for (int i = 0; i < size; i++) {
            if (find(i) == i) {
                regions++;
            }
        }
        return regions;
    }
}