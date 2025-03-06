class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        Set<Integer> seen = new HashSet<>();
        int[] res = new int[2];
        int expectedSum = ((grid.length*grid.length)*((grid.length*grid.length) + 1))/2;
        System.out.println(expectedSum);
        int sum = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(seen.contains(grid[i][j])){
                    res[0] = grid[i][j];
                }else{
                    seen.add(grid[i][j]);
                    sum += grid[i][j];
                }
            }
        }
        res[1] = expectedSum - sum;
        return res;
    }
}