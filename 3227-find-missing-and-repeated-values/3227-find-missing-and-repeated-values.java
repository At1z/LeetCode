class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        Set<Integer> seen = new HashSet<>();
        int[] res = new int[2];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(seen.contains(grid[i][j])){
                    res[0] = grid[i][j];
                }else{
                    seen.add(grid[i][j]);
                }
            }
        }
        for(int i = 1; i <= seen.size() + 1; i++){
            if(!seen.contains(i)){
                res[1] = i;
                break;
            }
        }
        return res;
    }
}