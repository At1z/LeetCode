class Solution {
    int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int minTimeToReach(int[][] moveTime) {
        int rows = moveTime.length;
        int cols = moveTime[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((room1, room2) -> room1[2]-room2[2] );
        int[][] visited = new int[rows][cols];
        pq.add(new int[]{0,0,0}); // row, col, value
        visited[0][0] = 1;
        while(!pq.isEmpty()){
            int[] curRoom = pq.poll();
            if(curRoom[0] == rows - 1 && curRoom[1] == cols - 1){
                return curRoom[2];
            }
            for(int[] d:dir){
                if(curRoom[0] + d[0] >= 0 && curRoom[0] + d[0] < rows && curRoom[1] + d[1] >= 0 && curRoom[1] + d[1] < cols && visited[curRoom[0] + d[0]][curRoom[1] + d[1]] != 1 ){
                    visited[curRoom[0] + d[0]][curRoom[1] + d[1]] = 1;
                    pq.add(new int[]{curRoom[0] + d[0], curRoom[1] + d[1], Math.max(curRoom[2] + 1, moveTime[curRoom[0] + d[0]][curRoom[1] + d[1]] + 1)});
                }
            }
            
        }

        return -1;
    }
}