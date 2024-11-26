class Solution {
    public int findChampion(int n, int[][] edges) {
        if(n < 2){
            return 0;
        }
        if(edges.length < n - 1){
            return -1;
        }
        Set<Integer> secondHashSet = new HashSet<>();
        Set<Integer> used = new HashSet<>();
        int res = 0;
        int value = 0;
        for (int[] edge : edges) {
            secondHashSet.add(edge[1]);
        }
        for (int i = 0; i < n; i++) {
            if (!secondHashSet.contains(i) && !used.contains(i)) {
                res += 1;
                value = i;
                used.add(value);
            }
        }

        return (res == 1) ? value : -1;
    }
}
