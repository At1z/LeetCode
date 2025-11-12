class Solution {
    public int addRungs(int[] rungs, int dist) {
        int curFloor = 0;
        int newRungs = 0;
        int index = 0;
        while(curFloor < rungs[rungs.length-1]){
            if(curFloor + dist >= rungs[index]){
                curFloor = rungs[index++];
            }else{
                int distnaceBetween = rungs[index] - curFloor;
                if(dist == 1){
                    newRungs += distnaceBetween - 1;
                    curFloor = rungs[index] - 1;
                }else if(distnaceBetween % dist == 0){
                    newRungs += distnaceBetween/dist - 1;
                    curFloor = rungs[index] - dist;
                }
                else{
                    newRungs += distnaceBetween/dist;
                    curFloor = rungs[index] - (distnaceBetween % dist);
                }
            }
        }

        return newRungs;
    }
}