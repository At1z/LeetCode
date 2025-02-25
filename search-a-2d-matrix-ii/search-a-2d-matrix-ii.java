class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int[][] visited = new int[matrix.length][matrix[0].length];
        Queue<int[]> bfs = new LinkedList<>();
        bfs.add(new int[] {0, 0});
        
        while(!bfs.isEmpty()){
            
            for(int i = 0; i < bfs.size(); i++){
                int[] cur = bfs.poll();
                
                if(cur[0] < 0 ||
                   cur[0] >= matrix.length ||
                   cur[1] < 0 ||
                   cur[1] >= matrix[0].length ||
                   visited[cur[0]][cur[1]] == 1) {
                    continue;
                }
                if(matrix[cur[0]][cur[1]]== target){
                    return true;
                }
                
                visited[cur[0]][cur[1]] = 1;
                bfs.add(new int[]{cur[0] + 1,cur[1]});
                bfs.add(new int[]{cur[0],cur[1] + 1});
            }   
        }
        return false;
    }
}