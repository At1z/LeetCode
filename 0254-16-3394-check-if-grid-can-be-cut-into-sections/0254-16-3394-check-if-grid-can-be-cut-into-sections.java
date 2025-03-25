class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        Arrays.sort(rectangles,(a,b)-> a[0] - b[0]);
        List<int[]> x = new ArrayList<>();
        int startX = rectangles[0][0];
        int endX = rectangles[0][2];
        for(int i = 1; i < rectangles.length; i++){
            int curStartX = rectangles[i][0];
            int curEndX = rectangles[i][2];
            if(curStartX < endX){
                if(curEndX > endX){
                    endX = curEndX;
                }
            }else{
                x.add(new int[]{startX,endX});
                startX = curStartX;
                endX = curEndX;
            }
        }
        x.add(new int[]{startX,endX});
        System.out.println(x.size());
        if(x.size() >= 3){
            return true;
        }
        Arrays.sort(rectangles,(a,b)-> a[1] - b[1]);
        List<int[]> y = new ArrayList<>();
        int startY = rectangles[0][1];
        int endY = rectangles[0][3];
        for(int i = 1; i < rectangles.length; i++){
            int curStartY = rectangles[i][1];
            int curEndY = rectangles[i][3];
            if(curStartY < endY){
                if(curEndY > endY){
                    endY = curEndY;
                }
            }else{
                y.add(new int[]{startY,endY});
                startY = curStartY;
                endY = curEndY;
            }
        }
        y.add(new int[]{startY,endY});
        System.out.println(y.size());
        if(y.size() >= 3){
            return true;
        }
        return false;
    }
}

